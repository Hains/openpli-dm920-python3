DESCRIPTION = "uchardet is a C language binding of the original C++ \
implementation of the universal charset detection library by Mozilla."
HOMEPAGE = "https://github.com/BYVoid/uchardet"
LICENSE = "MPLv1.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=6ecda54f6f525388d71d6b3cd92f7474"

SRCREV = "50743e16f8fd85534ae24db7ef997ece46e0ed25"

SRC_URI = "git://anongit.freedesktop.org/uchardet/uchardet.git;branch=master"

S = "${WORKDIR}/git"

inherit pkgconfig cmake gitpkgv

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
