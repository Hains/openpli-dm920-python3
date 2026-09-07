DESCRIPTION = "SoftCSA / iCAM descramble whitelist"
MAINTAINER = "AbuBaniaz"
LICENSE = "LicenseRef-LICENSE-CLOSED"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/LICENSE-CLOSED;md5=2d5b03b35d4612637d67724b35738dd7"

PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"

SRC_ORIGIN ?= "git://github.com/E2OpenPlugins/oscam-whitelist.git;protocol=https;branch=main"
SRC_URI := "${SRC_ORIGIN} "

inherit allarch gitpkgv

RDEPENDS:${PN} += "libdvbcsa"

do_install () {
	install -d ${D}${sysconfdir}/enigma2/
	if [ -f ${D}${sysconfdir}/enigma2/whitelist_sofcsa ]; then
		rm -f ${D}${sysconfdir}/enigma2/whitelist_softcsa
	fi
	cp -r ${S}/whitelist_softcsa ${D}${sysconfdir}/enigma2
}
