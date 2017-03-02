SRCREV = "3733039610d76231e404ebf089f0ff2b9d8e5490"

SRC_URI = "git://github.com/FFmpeg/FFmpeg.git"

S = "${WORKDIR}/git/"

inherit gitpkgv

PV = "3.2.4+git${SRCPV}"
PKGV = "3.2.4+git${GITPKGV}"
