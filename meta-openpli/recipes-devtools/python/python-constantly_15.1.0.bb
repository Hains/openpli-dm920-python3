SUMMARY = "A library that provides symbolic constant support. It includes collections and constants with text, numeric, and bit flag values."
SECTION = "devel/python"
HOMEPAGE = "https://pypi.python.org/pypi/constanly"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e393e4ddd223e3a74982efa784f89fd7"
PR = "r0"

inherit setuptools

SRC_URI = "https://pypi.python.org/packages/95/f1/207a0a478c4bb34b1b49d5915e2db574cadc415c9ac3a7ef17e29b2e8951/constantly-${PV}.tar.gz"

S = "${WORKDIR}/constantly-${PV}"

SRC_URI[md5sum] = "f0762f083d83039758e53f8cf0086eef"
SRC_URI[sha256sum] = "586372eb92059873e29eba4f9dec8381541b4d3834660707faf8ba59146dfc35"
