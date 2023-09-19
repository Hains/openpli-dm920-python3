SUMMARY = "E2i Player for E2"
DESCRIPTION = "E2i Player for E2"
HOMEPAGE = "http://www.iptvplayer.gitlab.io/"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
require conf/license/license-gplv2.inc

inherit allarch setuptools-openplugins gitpkgv

DEPENDS = "${PYTHON_PN}-future-native"

SRC_URI = "git://github.com/oe-mirrors/e2iplayer.git;branch=python3;protocol=https \
           file://use-setuptools-instead-of-distutils.patch \
"

S = "${WORKDIR}/git"

PV = "1+git"
PKGV = "1+git${GITPKGV}"

RDEPENDS:${PN} = " \
	cmdwrapper \
	duktape \
	exteplayer3 \
	f4mdump \
	ffmpeg \
	gst-ifdsrc \
	gstplayer \
	hlsdl \
	iptvsubparser \
	lsdir \
	python3-core \
	python3-e2icjson \
	python3-pycurl \
	rtmpdump \
	uchardet \
	wget \
	"

RDEPENDS:{PN}-src = "${PN}"

FILES:${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*-py${PYTHON_BASEVERSION}.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa

FILES:${PN} += "${sysconfdir}"
