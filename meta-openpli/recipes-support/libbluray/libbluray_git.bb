SUMMARY  = "Library to access Blu-Ray disk"
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=435ed639f84d4585d93824e7da3d85da"

DEPENDS = "libxml2"

SRC_URI = "gitsm://code.videolan.org/videolan/libbluray.git;protocol=https;branch=master"

inherit gitpkgv setuptools3 autotools-brokensep pkgconfig

PV = "v1.1.0+git"
PKGV = "v1.1.0+git${GITPKGV}"

EXTRA_OECONF = " \
	--disable-bdjava-jar \
	--disable-doxygen-doc \
	--disable-doxygen-dot \
	--without-freetype \
	--without-fontconfig \
	"
