DESCRIPTION = "Plugin for monitoring and testing HdmiCec"
MAINTAINER = "ims"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=534862957bf314f95d85e0c07632f84d"

inherit gitpkgv setuptools-openplugins
PV = "2.0+git"
PKGV = "2.0+git${GITPKGV}"

SRC_URI = "git://github.com/ims21/HdmiTest.git;protocol=https;branch=master \
           file://use-setuptools-instead-of-distutils.patch \
"

S="${WORKDIR}/git"
