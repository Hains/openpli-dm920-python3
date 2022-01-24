SUMMARY = "Start, stop and select softcams."
MAINTAINER = "PLi team"

require conf/license/openpli-gplv2.inc

inherit allarch

PACKAGES = "${PN}"

PV = "2"

INITSCRIPT_NAME = "softcam"
INITSCRIPT_PARAMS = "defaults 50"
inherit update-rc.d

FILES:${PN} = "${sysconfdir}"

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${S}/softcam.None ${D}${sysconfdir}/init.d/softcam.None
}

do_compile:append() {
	echo "# Placeholder for no cam" > ${S}/softcam.None
}

pkg_postinst:${PN} () {
	if [ ! -e "$D${sysconfdir}/init.d/softcam" ]
	then
		ln -s softcam.oscam $D${sysconfdir}/init.d/softcam
	fi
}
