MODULE = "ShootYourScreen"
DESCRIPTION = "create screenshots with remote control of your STB"
PACKAGE_ARCH = "${MACHINE_ARCH}"
RDEPENDS:${PN} = "aio-grab"

inherit setuptools3-openplugins

PV_MOD = "0.2+git"
PKGV_MOD = "0.2+git${GITPKGV}"

require openplugins.inc
