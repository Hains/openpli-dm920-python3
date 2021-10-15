SUMMARY = "E2i Player for E2"
DESCRIPTION = "E2i Player for E2"
HOMEPAGE = "http://www.iptvplayer.gitlab.io/"
SECTION = "multimedia"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = " git://github.com/Hains/e2iplayer.git;branch=python3;protocol=http \
			file://001-Remove-ov-lock.patch \
"

S = "${WORKDIR}/git"

inherit gitpkgv

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit allarch distutils-openplugins

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
	${libdir}/enigma2/python/Plugins/*-py3.10.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa

FILES:${PN} += "${sysconfdir}"

do_install:append() {
    install -d ${D}${sysconfdir}
    cp -r  --preserve=mode,links ${S}/vk ${D}${sysconfdir}/vk
}
