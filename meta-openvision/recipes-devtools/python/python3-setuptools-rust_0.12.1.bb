SUMMARY = "Setuptools rust extension plugin"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=011cd92e702dd9e6b1a26157b6fd53f5"

SRC_URI[sha256sum] = "647009e924f0ae439c7f3e0141a184a69ad247ecb9044c511dabde232d3d570e"

inherit rust pypi setuptools3

#UPSTREAM_CHECK_REGEX = "setuptools_scm-(?P<pver>.*)\.tar"

DEPENDS += "\
    ${PYTHON_PN}-wheel-native \
    ${PYTHON_PN}-setuptools-scm-native \
"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-py \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-toml \
"

RDEPENDS_${PN}_class-native = "\
    ${PYTHON_PN}-setuptools-native \
    ${PYTHON_PN}-toml-native \
"

BBCLASSEXTEND = "native nativesdk"
