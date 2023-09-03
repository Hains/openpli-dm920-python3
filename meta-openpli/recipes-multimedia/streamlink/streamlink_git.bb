SUMMARY = "CLI for extracting streams from various websites to a video player of your choosing"
DESCRIPTION = "Streamlink is a command-line utility that pipes video streams from various services into a video player, such as VLC."
HOMEPAGE = "https://github.com/streamlink/streamlink"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b026f0197dc4ce773b97e3dc1f55f55c"

DEPENDS += "python3-versioningit-native"

RDEPENDS:${PN} = "${PYTHON_PN}-core \
	${PYTHON_PN}-ctypes \
	${PYTHON_PN}-isodate \
	${PYTHON_PN}-pycountry \
	${PYTHON_PN}-lxml \
	${PYTHON_PN}-misc \
	${PYTHON_PN}-pkgutil \
	${PYTHON_PN}-pycryptodome \
	${PYTHON_PN}-pysocks \
	${PYTHON_PN}-requests \
	${PYTHON_PN}-shell \
	${PYTHON_PN}-singledispatch \
	${PYTHON_PN}-websocket-client \
"

inherit setuptools3 python3-dir

SRCREV_plugins = "${AUTOREV}"
SRCREV_FORMAT = "streamlink_plugins"

PV = "git"
PKGV = "${GITPKGVTAG}"

SRC_URI = " git://github.com/streamlink/streamlink;protocol=https;branch=master \
			git://github.com/oe-mirrors/streamlink-plugins;protocol=https;branch=master;name=plugins;destsuffix=additional-plugins \
"

S = "${WORKDIR}/git"

do_unpack:append() {
    bb.build.exec_func('do_prepare_plugins_dir', d)
}

do_prepare_plugins_dir() {
	cp -f ${WORKDIR}/additional-plugins/*.py ${S}/src/streamlink/plugins
}

do_install:append() {
	rm -rf ${D}${bindir}
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/streamlink_cli
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/*.egg-info
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/streamlink/plugins/.removed
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/*dirty.dist-info
	rm -rf ${D}${datadir}
}

PACKAGES = "${PN}"

FILES:${PN} = " \
	${libdir}/${PYTHON_DIR}/site-packages/streamlink/* \
"
