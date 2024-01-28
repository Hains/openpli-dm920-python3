MODULE = "AutoShutDown"
DESCRIPTION = "automated power off for STB"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools gettext

PV_MOD = "0.6+git"
PKGV_MOD = "0.6+git${GITPKGV}"

require openplugins.inc

FILES:${PN} = "/"
