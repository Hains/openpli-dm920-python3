HOMEPAGE = "https://github.com/Dima73/${PLUGINNAME}"

SRC_URI = "git://github.com/Dima73/${PLUGINNAME}.git;protocol=https;branch=master"

inherit gitpkgv setuptools3-openplugins

PV = "1+git"
PKGV = "1+git${GITPKGV}"

include python3-package-split.inc
