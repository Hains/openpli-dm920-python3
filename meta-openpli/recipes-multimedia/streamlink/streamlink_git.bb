SUMMARY = "CLI for extracting streams from various websites to a video player of your choosing"
DESCRIPTION = "Streamlink is a command-line utility that pipes video streams from various services into a video player, such as VLC."
HOMEPAGE = "https://github.com/streamlink/streamlink"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bdeccdbc612afcae11e2a92dafa75e35"

DEPENDS += "python3-versioningit-native"

RDEPENDS:${PN} = "python3-core \
	python3-ctypes \
	python3-isodate \
	python3-pycountry \
	python3-lxml \
	python3-misc \
	python3-pkgutil \
	python3-pycryptodome \
	python3-pysocks \
	python3-requests \
	python3-shell \
	python3-singledispatch \
	python3-websocket-client \
"

inherit setuptools3 python3-dir gitpkgv

SRCREV_plugins = "${AUTOREV}"
SRCREV_FORMAT = "streamlink_plugins"

PV = "6.8.3+git"
PKGV = "6.8.3+${GITPKGV}"

SRC_URI = " git://github.com/streamlink/streamlink;protocol=https;branch=master \
			git://github.com/oe-mirrors/streamlink-plugins;protocol=https;branch=master;name=plugins;destsuffix=additional-plugins \
"

S = "${WORKDIR}/git"

do_unpack:append() {
    bb.build.exec_func('do_prepare_plugins_dir', d)
}

do_prepare_plugins_dir() {
	cp -f ${UNPACKDIR}/additional-plugins/*.py ${S}/src/streamlink/plugins
}

do_install:append() {
	rm -rf ${D}${bindir}
	rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/streamlink_cli
	rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/*.egg-info
	rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/streamlink/plugins/.removed
	rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/*dirty.dist-info
	rm -rf ${D}${datadir}
}

PACKAGES = "${PN}"

FILES:${PN} = " \
	${PYTHON_SITEPACKAGES_DIR}/streamlink/* \
"
