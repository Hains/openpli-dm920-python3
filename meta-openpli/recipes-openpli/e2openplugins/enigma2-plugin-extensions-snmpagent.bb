MODULE = "SnmpAgent"
DESCRIPTION = "SNMP Agent"

RDEPENDS:${PN} = "enigma2-plugin-extensions-bitrate twistedsnmp"

require conf/license/license-gplv2.inc
require openplugins.inc
require openplugins-distutils.inc
