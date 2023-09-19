DESCRIPTION = "NewVirtualKeyBoard plugin by mfaraj57"
MAINTAINER = "Open Vision Developers"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/OpenVisionE2/NewVirtualKeyBoard.git;protocol=https;branch=master"

# don't inherit allarch, it can't work with arch-dependent RDEPENDS
inherit gitpkgv setuptools-openplugins gettext python3-compileall

S = "${WORKDIR}/git"

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

FILES:${PN} = "/usr/"

do_install() {
	install -d ${D}/usr
	cp -r ${S}/usr/* ${D}/usr/
}

python populate_packages:prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
}
