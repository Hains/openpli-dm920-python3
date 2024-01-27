SUMMARY = "Google Data APIs Python Client Library"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.txt;md5=4c8f0e6846e52a7fe4943acf462d808d"
HOMEPAGE = "http://code.google.com/p/gdata-python-client/"

SRC_URI[md5sum] = "13b6e6dd8f9e3e9a8e005e05a8329408"
SRC_URI[sha256sum] = "56e7d22de819c22b13ceb0fe1869729b4287f89ebbd4bb55380d7bcf61a1fdb6"

S = "${WORKDIR}/gdata.py-${PV}"

inherit pypi setuptools3

FILES:${PN} += "${datadir}"

RDEPENDS:${PN} = " \
    python3-json \
    python3-netserver \
    python3-stringold \
    python3-xml \
"
