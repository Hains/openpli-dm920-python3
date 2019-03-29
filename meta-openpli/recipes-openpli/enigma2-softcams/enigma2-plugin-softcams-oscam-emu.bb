require conf/license/openpli-gplv2.inc
require softcam.inc
inherit cmake

DESCRIPTION = "OScam-emu ${PV} Open Source Softcam"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "svn${SRCPV}"
PKGV = "${PV}"

SRC_URI = "svn://www.streamboard.tv/svn/oscam;protocol=http;module=trunk;scmdata=keep"

FILESEXTRAPATHS_prepend := "${THISDIR}/enigma2-plugin-softcams-oscam:"
PATCHREV = "e10c97b143d5e2a08bf8e4f9466072afb1f0ea42"
PR = "r792"
SRC_URI += "https://raw.githubusercontent.com/oscam-emu/oscam-emu/${PATCHREV}/oscam-emu.patch?${PATCHREV};downloadfilename=oscam-emu.${PATCHREV}.patch;name=emu;striplevel=0"

SRC_URI[emu.md5sum] = "537cf7fa49578887e67004ad4a911c0e"
SRC_URI[emu.sha256sum] = "d7bc07a77fe3b8b9a514bf1488f2fd04dedc650a0e0ab901b3d9c2960992a30f"

DEPENDS = "libusb openssl"

S = "${WORKDIR}/trunk"
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
	-DHAVE_PCSC=0"

do_install() {
	install -d ${D}${sysconfdir}/tuxbox/config/oscam-emu
	install -m 0644 ${WORKDIR}/oscam.* ${D}${sysconfdir}/tuxbox/config/oscam-emu
	install -d ${D}${bindir}
	install -m 0755 ${B}/oscam ${D}${bindir}/oscam-emu
}
