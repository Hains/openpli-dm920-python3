require conf/license/openpli-gplv2.inc
require softcam.inc
inherit cmake gitpkgv

DESCRIPTION = "OScam-emu ${PV} Open Source Softcam"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "1.20+git${SRCPV}"
PKGV = "1.20+git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/oscam.git;protocol=https"

FILESEXTRAPATHS_prepend := "${THISDIR}/enigma2-plugin-softcams-oscam:"
PATCHREV = "59bb32ea503a02791f0165017679c9851206a797"
PR = "r797"
SRC_URI += "https://raw.githubusercontent.com/oscam-emu/oscam-emu/${PATCHREV}/oscam-emu.patch?${PATCHREV};downloadfilename=oscam-emu.${PATCHREV}.patch;name=emu;striplevel=0"

SRC_URI[emu.md5sum] = "7a98677cae65899abd5294b53b6bc5e2"
SRC_URI[emu.sha256sum] = "3de989fed42b5a493a0ac4b56a11057ce2fedf21fdf6e5aad9a7a342ec06362c"

DEPENDS = "libusb openssl"

S = "${WORKDIR}/git"
B = "${S}"

CAMNAME = "oscam-emu"
CAMSTART = "exec start-stop-daemon -S -x /usr/bin/oscam-emu -- -b -r 2 -c /etc/tuxbox/config/oscam-emu"
CAMSTOP =  "exec start-stop-daemon -K -R 2 -x /usr/bin/oscam-emu"

SRC_URI += " \
	file://oscam.conf \
	file://oscam.server \
	file://oscam.srvid \
	file://oscam.user \
	file://oscam.provid"

CONFFILES = "${sysconfdir}/tuxbox/config/oscam-emu/oscam.conf ${sysconfdir}/tuxbox/config/oscam-emu/oscam.server ${sysconfdir}/tuxbox/config/oscam-emu/oscam.srvid ${sysconfdir}/tuxbox/config/oscam-emu/oscam.user ${sysconfdir}/tuxbox/config/oscam-emu/oscam.provid"

FILES_${PN} = "${bindir}/oscam-emu ${sysconfdir}/tuxbox/config/oscam-emu/* ${sysconfdir}/init.d/softcam.oscam-emu"

EXTRA_OECMAKE += "\
	-DOSCAM_SYSTEM_NAME=Tuxbox \
	-DWEBIF=1 \
	-DWITH_STAPI=0 \
	-DHAVE_LIBUSB=1 \
	-DSTATIC_LIBUSB=1 \
	-DWITH_SSL=1 \
	-DIPV6SUPPORT=1 \
	-DHAVE_PCSC=1 \
	-DCARDREADER_SMARGO=1 \
	-DCARDREADER_PCSC=1 \
	-DCW_CYCLE_CHECK=1 \
	-DCS_CACHEEX=1 \
	-DMODULE_CONSTCW=1 \
	"

do_install() {
	install -d ${D}${sysconfdir}/tuxbox/config/oscam-emu
	install -m 0644 ${WORKDIR}/oscam.* ${D}${sysconfdir}/tuxbox/config/oscam-emu
	install -d ${D}${bindir}
	install -m 0755 ${B}/oscam ${D}${bindir}/oscam-emu
}
