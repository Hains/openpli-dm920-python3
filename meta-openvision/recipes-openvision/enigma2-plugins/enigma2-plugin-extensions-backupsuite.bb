DESCRIPTION = "Backup Suite"
LICENSE = "GPLv3"
MAINTAINER = "Open Vision Developers"
AUTHOR = "Pedro Newbie <pedro.newbie@gmail.com>"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = " git://github.com/OpenVisionE2/BackupSuite.git;protocol=git \
			file://remove-e-options.patch \
			"

# don't inherit allarch, it can't work with arch-dependent RDEPENDS
inherit gitpkgv distutils-openplugins gettext

RDEPENDS_${PN} = "mtd-utils mtd-utils-ubifs mtd-utils-jffs2 dreambox-buildimage"

S = "${WORKDIR}/git"

PV = "26+git${SRCPV}"
PKGV = "26+git${GITPKGV}"

do_install_append() {
	find "${D}" -name '*.sh' -exec chmod a+x '{}' ';'
}

FILES_${PN}-src = "\
    /usr/lib/enigma2/python/*/*.py \
    /usr/lib/enigma2/python/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*/*/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*/*/*/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*/*/*/*/*/*/*.py \
    /usr/lib/enigma2/python/*/*/*/*/*/*/*/*/*/*/*.py \
    "

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
}
