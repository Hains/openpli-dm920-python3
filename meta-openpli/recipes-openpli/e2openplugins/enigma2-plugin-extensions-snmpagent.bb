MODULE = "SnmpAgent"
DESCRIPTION = "SNMP Agent"

inherit setuptools3-openplugins

RDEPENDS:${PN} = "enigma2-plugin-extensions-bitrate twistedsnmp"

require openplugins.inc
