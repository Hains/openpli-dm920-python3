MODULE = "OscamStatus"
DESCRIPTION = "shows status of your oscam server"

inherit setuptools3-openplugins

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require openplugins.inc

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-OscamStatus.git;protocol=https;branch=master file://use-setuptools-instead-of-distutils.patch"
