MODULE = "Blackoutblind"
DESCRIPTION = "Hide white dotted lines (VBI) on top of the screen"

inherit setuptools3-openplugins

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require openplugins.inc

BRANCH = "master"
