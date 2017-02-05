SUMMARY  = "Library to access Blu-Ray disk"
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=435ed639f84d4585d93824e7da3d85da"

DEPENDS = "libxml2"

SRCREV="60e3d2600e8aaba3ca01df73569424befd9ed6fb"

SRC_URI = " gitsm://git.videolan.org/libbluray.git"

inherit gitpkgv autotools-brokensep pkgconfig

PV = "v0.9.3+git${SRCPV}"
PKGV = "v0.9.3+git${GITPKGV}"

S="${WORKDIR}/git"

EXTRA_OECONF = " \
	--disable-bdjava \
	--disable-bdjava-jar \
	--disable-doxygen-doc \
	--disable-doxygen-dot \
	--without-freetype \
	--without-fontconfig \
	"
