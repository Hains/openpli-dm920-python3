MODULE = "WakeOnLan"
DESCRIPTION = "Send a WOL packet to devices"

inherit setuptools3-openplugins

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require openplugins.inc
