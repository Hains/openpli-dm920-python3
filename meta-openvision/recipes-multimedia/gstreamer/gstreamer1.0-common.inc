S = "${WORKDIR}/git"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))"

inherit gitpkgv
PV = "1.17.0.1+git${SRCPV}"
PKGV = "1.17.0.1+git${GITPKGV}"

GST_BRANCH ?= "master"
