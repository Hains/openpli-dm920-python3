MODULE = "BhTunerServer"
DESCRIPTION = "Build a virtual channel list of .m3u files to allow streaming from a client vial lan or UPnP "

inherit setuptools3-openplugins

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require openplugins.inc
