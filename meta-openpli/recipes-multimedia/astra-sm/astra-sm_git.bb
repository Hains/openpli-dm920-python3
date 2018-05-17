SUMMARY  = "A professional software to organize Digital TV Broadcasting Service for \
	TV operators and broadcasters, internet service providers, hotels, etc."
SECTION = "multimedia"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = "openssl libdvbcsa"

SRC_URI = "git://gitlab.com/crazycat69/astra-sm.git;protocol=http \
    file://astra \
    file://config.lua \
"

inherit gitpkgv autotools-brokensep pkgconfig update-rc.d

SRCREV = "${AUTOREV}"
PV = "0.2+git${SRCPV}"
PKGV = "0.2+git${GITPKGV}"
PR = "1"

S="${WORKDIR}/git"

do_install_append() {
	rmdir ${D}${sysconfdir}/astra/scripts
	install -D -m 755 ${WORKDIR}/astra ${D}${sysconfdir}/init.d/astra
	install -D -m 644 ${WORKDIR}/config.lua ${D}${sysconfdir}/astra/config.lua
}

FILES_${PN} += "${sysconfdir}/init.d/astra"
FILES_${PN}-dev += "${datadir}"

INITSCRIPT_NAME = "astra"
INITSCRIPT_PARAMS = "start 84 3 . stop 12 6 ."
CONFFILES = "${sysconfdir}/astra/config.lua"
