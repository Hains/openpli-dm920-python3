S = "${WORKDIR}/git"

inherit gitpkgv2

VERSION := "${PV}"
PV = "${VERSION}+git"
PKGV = "${VERSION}+git${GITPKGV}"
