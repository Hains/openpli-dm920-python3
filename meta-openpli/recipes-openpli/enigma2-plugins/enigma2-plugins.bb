DESCRIPTION = "Additional plugins for Enigma2"
MAINTAINER = "OpenPLi team <info@openpli.org>"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=8e37f34d0e40d32ea2bc90ee812c9131"

PACKAGES_DYNAMIC = "enigma2-plugin-(?!pli-).*"

# This prevents QA warnings because bitbake cannot see the dependencies
# after parsing the recipe due to the PACKAGES_DYNAMIC stuff. It tells
# the system what to build when installing these into an image.
PACKAGES += "\
	enigma2-plugin-extensions-mosaic \
	enigma2-plugin-extensions-fancontrol2 \
	enigma2-plugin-extensions-bonjour \
	enigma2-plugin-extensions-transmission \
	enigma2-plugin-systemplugins-systemtime \
	"
RDEPENDS_enigma2-plugin-extensions-mosaic = "aio-grab"
RDEPENDS_enigma2-plugin-extensions-fancontrol2 = "smartmontools hdparm"
RDEPENDS_enigma2-plugin-extensions-bonjour = "avahi-daemon"

RRECOMMENDS_enigma2-plugin-systemplugins-blindscan = "virtual/blindscan-dvbs"
RRECOMMENDS_enigma2-plugin-systemplugins-systemtime = "ntpdate"
RRECOMMENDS_enigma2-plugin-extensions-transmission = "transmission transmission-client"

inherit gitpkgv python3native pkgconfig

PV = "y-git${SRCPV}"
PKGV = "y-git${GITPKGV}"

GITHUB_URI ?= "git://github.com"
SRC_URI = "${GITHUB_URI}/Hains/${BPN}.git;branch=python3;protocol=https"

EXTRA_OECONF = " \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	--without-debug \
"

# Main package should be empty
FILES:${PN} = ""
# But something makes the packages think they depend on it, so just
# deliver an empty hulk for them.
ALLOW_EMPTY:${PN} = "1"

FILES:enigma2-plugin-extensions-movietagger += "${sysconfdir}/enigma2/movietags"
CONFFILES:enigma2-plugin-extensions-movietagger += "${sysconfdir}/enigma2/movietags"

FILES:enigma2-plugin-extensions-babelzapper += "${sysconfdir}/babelzapper"

FILES:enigma2-plugin-extensions-netcaster += "${sysconfdir}/NETcaster.conf"
CONFFILES:enigma2-plugin-extensions-netcaster += "${sysconfdir}/NETcaster.conf"

FILES:${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta ${PN}-build-dependencies"

inherit autotools-brokensep

S = "${WORKDIR}/git"

DEPENDS = " \
	python3-pyopenssl \
	streamripper \
	python3-mutagen \
	python3-twisted \
	python3-daap \
	libcddb \
	dvdbackup \
	libtirpc \
	"

do_compile() {
	python3 -m compileall ${S}
}

CFLAGS += "-I${STAGING_INCDIR}/tirpc"

python populate_packages:prepend () {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)

    def getControlLines(mydir, package):
        import os
        try:
            src = open(mydir + package + "/CONTROL/control").read()
        except Exception as ex:
            bb.note("Failed to get control lines for package '%s': %s" % (package, ex))
            return
        for line in src.split("\n"):
            full_package = "enigma2-plugin-extensions-" + package
            if line.startswith('Package: '):
                full_package = line[9:]
            elif line.startswith('Recommends: '):
                d.setVar('RRECOMMENDS_' + full_package, line[12:])
            elif line.startswith('Description: '):
                d.setVar('DESCRIPTION_' + full_package, line[13:])
            elif line.startswith('Replaces: '):
                d.setVar('RREPLACES_' + full_package, ' '.join(line[10:].split(', ')))
            elif line.startswith('Conflicts: '):
                d.setVar('RCONFLICTS_' + full_package, ' '.join(line[11:].split(', ')))
            elif line.startswith('Maintainer: '):
                d.setVar('MAINTAINER_' + full_package, line[12:])


    mydir = d.getVar('D') + "/../git/"
    for package in d.getVar('PACKAGES').split():
        getControlLines(mydir, package.split('-')[-1])
}

do_install:append() {
	# remove leftover webinterface garbage
	rm -rf ${D}${libdir}/enigma2/python/Plugins/Extensions/WebInterface
}

# Nothing of this recipe should end up in sysroot, so blank it away.
sysroot_stage_all() {
    :
}
