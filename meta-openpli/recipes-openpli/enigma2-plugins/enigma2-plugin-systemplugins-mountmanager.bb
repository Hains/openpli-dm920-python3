DESCRIPTION = "Mount devices at your decision (label,uuid)"
HOMEPAGE = "https://github.com/Dima73/enigma2-plugin-mountmanager"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README;md5=0e36b30b1a9303e9763901f55c05e558"

SRC_URI = "git://github.com/Dima73/enigma2-plugin-mountmanager.git;protocol=https;branch=master"

inherit gitpkgv setuptools3-openplugins

PV = "1+git"
PKGV = "1+git${GITPKGV}"

RDEPENDS:${PN} = " \
	e2fsprogs-tune2fs \
	"
