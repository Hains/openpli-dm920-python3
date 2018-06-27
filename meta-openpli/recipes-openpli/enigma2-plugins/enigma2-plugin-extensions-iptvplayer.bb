SUMMARY = "IPTV Player for E2"
DESCRIPTION = "IPTV Player for E2"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://IPTVPlayer/plugin.py;md5=180a6bea75d2e48955fe9166eb94f095"
SRC_URI = " git://gitlab.com/iptvplayer-for-e2/iptvplayer-for-e2.git;protocol=http \
			file://add-support-openssl110g-support.patch \
			file://finish-after-ffmpeg.patch \
			"

S = "${WORKDIR}/git"

inherit gitpkgv

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit allarch distutils-openplugins

RRECOMMENDS_${PN} = " \
	duktape \
	exteplayer3 \
	f4mdump \
	ffmpeg \
	gst-ifdsrc \
	gstplayer \
	hlsdl \
	iptvsubparser \
	lsdir \
	python-core \
	rtmpdump \
	uchardet \
	wget \
	"

PACKAGES =+ " ${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa
