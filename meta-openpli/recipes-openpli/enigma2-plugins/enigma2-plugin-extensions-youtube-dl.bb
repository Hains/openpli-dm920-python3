SUMMARY = "Download videos from YouTube (and more sites)"
DESCRIPTION = "youtube-dl is a small command-line program to download videos \
from YouTube.com and a few more sites. It requires the Python interpreter \
(2.6, 2.7, or 3.2+), and it is not platform specific"
HOMEPAGE = "https://youtube-dl.org"
SECTION = "devel/python"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"

DEPENDS = "libxml2 bash-completion"

PE = "1"
PV = "2020.09.20"
PR = "r1"

SRC_URI = "https://distfiles.macports.org/youtube-dl/youtube-dl-${PV}.tar.gz"

SRC_URI[md5sum] = "ce6abd9cc401d2c7d2bb855088d7447b"
SRC_URI[sha256sum] = "ac1a799cf968345bf29089ed2e5c5d4f4a32031625d808369e61b6362d1c7cde"

S = "${WORKDIR}/youtube-dl"

inherit gitpkgv setuptools3

EXTRA_OEMAKE = "PYTHON=${PYTHON}"

do_compile:prepend() {
	oe_runmake lazy-extractors youtube-dl.bash-completion
}

do_install:append() {
	mv ${D}${datadir}/etc ${D}${sysconfdir}
	install -m 0755 -d ${D}${sysconfdir}/bash_completion.d
	install -m 0644 youtube-dl.bash-completion ${D}${sysconfdir}/bash_completion.d
}

RDEPENDS:${PN} = " \
	python3-email \
	python3-unixadmin \
	python3-ctypes \
	python3-html \
	"

FILES:${PN} += "${sysconfdir}"
