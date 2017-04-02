SRCREV = "7942907878dd4c263ba7431067c33ce6b5d53ceb"

SRC_URI = "git://github.com/FFmpeg/FFmpeg.git"

S = "${WORKDIR}/git/"

inherit gitpkgv

PV = "3.2.4+git${SRCPV}"
PKGV = "3.2.4+git${GITPKGV}"

PACKAGECONFIG[x11] = "--enable-x11grab"
