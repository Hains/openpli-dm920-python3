MODULE = "StreamInterface"
DESCRIPTION = "Stream webinterface on port 40080"

inherit setuptools3-openplugins

RDEPENDS:${PN} = "python3-twisted-web"

require openplugins.inc
