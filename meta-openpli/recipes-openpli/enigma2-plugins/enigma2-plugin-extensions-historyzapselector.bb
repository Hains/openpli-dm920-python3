DESCRIPTION = "Advanced history zap selector"
HOMEPAGE = "https://github.com/Dima73/enigma2-plugin-extensions-historyzapselector"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README;md5=b5f3c7ed409cbcc6d849e694f25729ba"

SRC_URI = "git://github.com/Dima73/enigma2-plugin-extensions-historyzapselector.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit gitpkgv setuptools-openplugins

PV = "1+git"
PKGV = "1+git${GITPKGV}"
