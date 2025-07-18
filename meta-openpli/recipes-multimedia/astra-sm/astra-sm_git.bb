SUMMARY = "Astra (Advanced Streamer) Slonik Mod"
DESCRIPTION = "Astra (Advanced Streamer) is a professional software to organize \
	Digital TV Service for TV operators and broadcasters, internet service providers, hotels, etc."
SECTION = "multimedia"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
DEPENDS = "openssl libdvbcsa libaio"

SRC_URI = "git://github.com/OpenVisionE2/astra-sm.git;branch=staging;protocol=https \
           file://replace-sys-siglist.patch \
           "

inherit gitpkgv autotools-brokensep pkgconfig update-rc.d gettext

PV = "0.2+git"
PKGV = "0.2+git${GITPKGV}"

do_install:append() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/src/tests/t2mi_decap ${D}${bindir}/
	install -d ${D}${sysconfdir}/init.d/
	install -D -m 755 ${S}/astra-sm ${D}${sysconfdir}/init.d/
	install -D -m 644 ${S}/astra-sm.lua ${D}${sysconfdir}/astra/
	install -D -m 644 ${S}/astra-sm.conf ${D}${sysconfdir}/astra/
}

FILES:${PN} += "${sysconfdir}/init.d/"
FILES:${PN}-dev += "${datadir}"

INITSCRIPT_NAME = "astra-sm"
INITSCRIPT_PARAMS = "defaults"

CFLAGS_FOR_BUILD += "-std=c99"

CONFFILES += "${sysconfdir}/astra/astra-sm.lua"
CONFFILES += "${sysconfdir}/astra/astra-sm.conf"
