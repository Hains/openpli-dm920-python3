MODULE = "OscamStatus"
DESCRIPTION = "shows status of your oscam server"

inherit gitpkgv
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

require conf/license/license-gplv2.inc
require openplugins-distutils.inc

SRC_URI = " git://github.com/Hains/e2openplugin-OscamStatus.git \
			file://fix-autodetection.patch \
			file://remove-duplicate-server-name.patch \
"
