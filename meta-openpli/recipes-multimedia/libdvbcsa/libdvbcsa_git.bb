SUMMARY  = "Free implementation of the DVB Common Scrambling Algorithm - DVB/CSA - with encryption and decryption capabilities"
SECTION = "libs/multimedia"
HOMEPAGE = "http://www.videolan.org/developers/libdvbcsa.html"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "git://code.videolan.org/videolan/libdvbcsa.git;protocol=https"

inherit gitpkgv autotools-brokensep pkgconfig

PV = "1.1.0+git${SRCPV}"
PKGV = "1.1.0+git${GITPKGV}"

S="${WORKDIR}/git"
