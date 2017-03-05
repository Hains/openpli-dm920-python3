SRCREV = "d757ddbaab8f03b3664788e620314b70ac791319"

SRC_URI = "git://github.com/FFmpeg/FFmpeg.git"

S = "${WORKDIR}/git/"

inherit gitpkgv

PV = "3.2.4+git${SRCPV}"
PKGV = "3.2.4+git${GITPKGV}"
