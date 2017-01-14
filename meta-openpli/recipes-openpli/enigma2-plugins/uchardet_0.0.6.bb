DESCRIPTION = "uchardet is a C language binding of the original C++ \
implementation of the universal charset detection library by Mozilla."
HOMEPAGE = "https://github.com/BYVoid/uchardet"
LICENSE = "MPLv1.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=6ecda54f6f525388d71d6b3cd92f7474"

SRCREV = "119fed7e8dcb7b9e72457ff2b268a61d2264f12d"

SRC_URI = "git://anongit.freedesktop.org/uchardet/uchardet.git;branch=master"

S = "${WORKDIR}/git"

inherit pkgconfig cmake gitpkgv

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
