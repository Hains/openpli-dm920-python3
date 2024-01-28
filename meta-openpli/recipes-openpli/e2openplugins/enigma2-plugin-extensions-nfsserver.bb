MODULE = "NfsServer"
DESCRIPTION = "NFS server configuration"

inherit setuptools3-openplugins

RDEPENDS:${PN} = "nfs-utils"

require openplugins.inc
