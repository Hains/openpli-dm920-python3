SRCREV = "de1308429ae649c899b74365f0dc72847676ba75"

SRC_URI = "git://github.com/FFmpeg/FFmpeg.git"

S = "${WORKDIR}/git/"

inherit gitpkgv

PV = "3.2.4+git${SRCPV}"
PKGV = "3.2.4+git${GITPKGV}"

PACKAGECONFIG[x11] = "--enable-x11grab"
