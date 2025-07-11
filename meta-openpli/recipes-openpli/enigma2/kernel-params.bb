PV = "20110114"
DESCRIPTION = "Tune kernel parameters in /etc/sysconf"

require conf/license/openpli-gplv2.inc

S = "${UNPACKDIR}"

PACKAGES = "${PN}"

SRC_URI = "file://sysctl.conf"

# Users may chose to edit or create their own
CONFFILES:${PN} = "${sysconfdir}/sysctl.conf"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0640 ${UNPACKDIR}/sysctl.conf ${D}${sysconfdir}/sysctl.conf
}
