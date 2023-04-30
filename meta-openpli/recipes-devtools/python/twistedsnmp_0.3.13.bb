DESCRIPTION = "twisted SNMP framework"
SECTION = "devel/python"
PRIORITY = "optional"
RDEPENDS:${PN} = "python3-pysnmp-se"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=c6f330cac7a286df5a2a7617fdda815f"

SRCNAME = "TwistedSNMP"
SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${SRCNAME}-${PV}.tar.gz \
           file://port-to-python3.patch \
"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools3

SRC_URI[md5sum] = "70716c4314f6c03a3da0cf57cabba03c"
SRC_URI[sha256sum] = "4e3d20110a3083bf4c602b57c5bcf447182bb0effcb8b0603f5da0314a804cce"

include python3-package-split.inc
