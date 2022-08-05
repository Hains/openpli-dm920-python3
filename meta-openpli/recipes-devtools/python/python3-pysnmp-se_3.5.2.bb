SUMMARY = "Python SNMP Toolkit (Speed Enhanced)"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://README;beginline=13;endline=14;md5=fe0c3d0cab1e25fcec2777b0a8b8e4bf"

RDEPENDS:${PN} = "${PYTHON_PN}-core"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/Hains/python3-pysnmp-se.git;branch=main;protocol=http"

S = "${WORKDIR}/git"

inherit setuptools3

include ${PYTHON_PN}-package-split.inc
