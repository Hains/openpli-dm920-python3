SRC_URI_append = "\
    git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
"

S = "${WORKDIR}/git"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))"

SRCREV_FORMAT = "base"

inherit gitpkgv
PV = "1.17.0.1+git${SRCPV}"
PKGV = "1.17.0.1+git${GITPKGV}"

GST_BRANCH ?= "master"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

