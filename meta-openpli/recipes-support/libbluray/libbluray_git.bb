SUMMARY  = "Library to access Blu-Ray disk"
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=435ed639f84d4585d93824e7da3d85da"

DEPENDS = "libxml2"

SRCREV= "6dffb7e606bed7e2d85e50625db7ee83e2ef668f"

SRC_URI = " gitsm://git.videolan.org/libbluray.git"

inherit gitpkgv autotools-brokensep pkgconfig

PV = "v1.0.0+git${SRCPV}"
PKGV = "v1.0.0+git${GITPKGV}"

S="${WORKDIR}/git"

EXTRA_OECONF = " \
	--disable-bdjava \
	--disable-bdjava-jar \
	--disable-doxygen-doc \
	--disable-doxygen-dot \
	--without-freetype \
	--without-fontconfig \
	"
