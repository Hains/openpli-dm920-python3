MODULE = "RemoteChannelStreamConverter"
DESCRIPTION = "Fetch channels from remote bouquets and make them available locally"

inherit setuptools3-openplugins

RDEPENDS:${PN} = "python3-shell"

require openplugins.inc

BRANCH = "master"
