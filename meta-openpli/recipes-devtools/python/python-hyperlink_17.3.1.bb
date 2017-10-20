SUMMARY = "Hyperlink is a featureful, pure-Python implementation of the URL, with an emphasis on correctness. BSD licensed."
SECTION = "devel/python"
HOMEPAGE = "https://pypi.python.org/pypi/hyperlink"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3893d4ed05dcc823f8ed685a9ea19bcb"
PR = "r0"

inherit setuptools

SRC_URI = "https://pypi.python.org/packages/83/df/3bdaf38f21f93429de02f04c6a967d2154955fc5b9a6a1a0b20a682edc13/hyperlink-${PV}.tar.gz"

S = "${WORKDIR}/hyperlink-${PV}"

SRC_URI[md5sum] = "eaccb9845b559817e838846669cbc68a"
SRC_URI[sha256sum] = "bc4ffdbde9bdad204d507bd8f554f16bba82dd356f6130cb16f41422909c33bc"
