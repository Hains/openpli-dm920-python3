MODULE = "NewsReader"
DESCRIPTION = "RSS reader"

require openplugins.inc
require openplugins-distutils.inc

do_install:append() {
	rm -rf ${D}/${datadir}
}

FILES:${PN} += "${sysconfdir}/feeds.xml"
CONFFILES:${PN} = "${sysconfdir}/feeds.xml"
