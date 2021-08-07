DESCRIPTION = "UpcaleDB/HamsterDB"
LICENSE = "GPLv3"

LIC_FILES_CHKSUM = "file://COPYING.GPL3;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "boost"

RREPLACES:${PN} = "hamsterdb"
CONFLICTS:${PN} = "hamsterdb"

SRC_URI = "git://github.com/cruppstahl/upscaledb.git;protocol=git"

S = "${WORKDIR}/git"

inherit gitpkgv autotools

PV = "2.1.12+git${SRCPV}"
PKGV = "2.1.12+git${GITPKGV}"
