SUMMARY = "biTStream is a set of C headers"
DESCRIPTION = "biTStream is a set of C headers allowing a simpler access to binary \
	structures such as specified by MPEG, DVB, IETF, SMPTE, IEEE, SCTE, etc."
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=7decd8ef15ab16ed5436851272b61cf7"

inherit autotools-brokensep pkgconfig gitpkgv

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://code.videolan.org/videolan/bitstream.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

do_compile:prepend() {
	sed -i 's#/usr/local#/usr#' ${S}/Makefile
}

do_install:append() {
	install -d ${D}${includedir}
}

