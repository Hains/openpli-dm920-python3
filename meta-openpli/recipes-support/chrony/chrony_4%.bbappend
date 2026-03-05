FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://chronyc.sh \
"

do_install:append() {
	# if-up script
	install -d ${D}${sysconfdir}/network/if-up.d
	install -c -m 755 ${WORKDIR}/chronyc.sh ${D}${sysconfdir}/network/if-up.d/chronyc.sh
}
