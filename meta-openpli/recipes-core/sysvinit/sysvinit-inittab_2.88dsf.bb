DESCRIPTION = "Inittab for sysvinit"

require conf/license/openpli-gplv2.inc

PR = "r6"

SRC_URI = "file://inittab"

S = "${UNPACKDIR}"

INHIBIT_DEFAULT_DEPS = "1"

do_compile() {
	:
}

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${UNPACKDIR}/inittab ${D}${sysconfdir}/inittab
}
