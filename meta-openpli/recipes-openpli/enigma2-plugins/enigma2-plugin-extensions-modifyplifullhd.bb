DESCRIPTION = "Modify colors anf font in PLi-FullHD and PLi-HD1"
MAINTAINER = "ims"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=534862957bf314f95d85e0c07632f84d"

inherit gitpkgv setuptools3-openplugins

PV = "2.0+git"
PKGV = "2.0+git${GITPKGV}"

SRC_URI = "git://github.com/ims21/ModifyPliFullHD.git;protocol=https;branch=master"
