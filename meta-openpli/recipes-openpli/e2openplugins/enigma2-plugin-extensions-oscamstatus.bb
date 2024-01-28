MODULE = "OscamStatus"
DESCRIPTION = "shows status of your oscam server"

inherit setuptools3-openplugins

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require openplugins.inc

BRANCH = "master"

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch"
