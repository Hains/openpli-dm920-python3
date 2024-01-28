MODULE = "NewsReader"
DESCRIPTION = "RSS reader"

inherit setuptools3-openplugins

require openplugins.inc

do_install:append() {
	rm -rf ${D}/${datadir}
}

FILES:${PN} += "${sysconfdir}/feeds.xml"
CONFFILES:${PN} = "${sysconfdir}/feeds.xml"
