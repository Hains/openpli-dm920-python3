DESCRIPTION = "Auto video clipping switcher for enigma2"
HOMEPAGE = "https://github.com/Dima73/vcs"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README;md5=8eddbaffb25ee762a200b712d7242dbe"

SRC_URI = "git://github.com/Dima73/vcs.git;protocol=https;branch=master"

inherit gitpkgv setuptools3-openplugins

PV = "1+git"
PKGV = "1+git${GITPKGV}"
