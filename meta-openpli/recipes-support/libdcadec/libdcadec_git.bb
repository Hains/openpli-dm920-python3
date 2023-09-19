SUMMARY = "DTS Coherent Acoustics decoder with support for HD extensions"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING.LGPLv2.1;md5=4fbd65380cdd255951079008b364516c"

inherit lib_package gitpkgv

SRCREV = "${AUTOREV}"
PV = "0.2+git"
PKGV = "0.2+git${GITPKGV}"

SRC_URI = "git://github.com/foo86/dcadec.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CONFIG_SHARED=1"

do_install() {
    oe_runmake install DESTDIR="${D}" PREFIX="${prefix}" LIBDIR="${libdir}"
}
