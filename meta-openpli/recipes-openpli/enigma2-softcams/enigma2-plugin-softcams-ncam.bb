MAINTAINER = "RAED Developer"
require conf/license/openpli-gplv2.inc
require softcam.inc
inherit cmake gitpkgv

DESCRIPTION = "ncam ${PV} Open Source Softcam"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "git"
PKGV = "git${GITPKGV}"
SRC_URI = "git://github.com/fairbird/NCam.git;protocol=https;branch=master"

DEPENDS = "libusb openssl libdvbcsa"

LDFLAGS:prepend = "-ludev -ldvbcsa "
EXTRA_OECONF = "LIBDVBCSA=yes "

B = "${S}"

CAMNAME = "ncam"
CAMSTART = "/usr/bin/ncam --wait 0 --config-dir /etc/tuxbox/config/ncam --daemon --pidfile /tmp/ncam.pid --restart 2 --utf8"
CAMSTOP = "kill \`cat /tmp/ncam.pid\` 2> /dev/null"

SRC_URI += "\
	file://ncam.conf \
	file://ncam.server \
	file://ncam.srvid \
	file://ncam.user \
	file://ncam.provid \
	file://CCcam.cfg \
	file://ncam.fs \
	file://ncam.services"

CONFFILES = "/etc/tuxbox/config/ncam/ncam.conf /etc/tuxbox/config/ncam/ncam.server /etc/tuxbox/config/ncam/ncam.srvid /etc/tuxbox/config/ncam/ncam.user /etc/tuxbox/config/ncam/ncam.provid /etc/tuxbox/config/ncam/CCcam.cfg /etc/tuxbox/config/ncam/ncam.services"

FILES:${PN} = "/usr/bin/ncam /etc/tuxbox/config/ncam/* /etc/init.d/softcam.ncam"

EXTRA_OECMAKE += "\
	-DOSCAM_SYSTEM_NAME=Tuxbox \
	-DWEBIF=1 \
	-DWITH_STAPI=0 \
	-DWITH_LIBCUR=1 \
	-DWITH_LIBCRYPTO=1 \
	-DHAVE_LIBUSB=1 \
	-DSTATIC_LIBUSB=1 \
	-DWITH_SSL=1 \
	-DIPV6SUPPORT=1 \
	-DCLOCKFIX=0 \
	-DHAVE_PCSC=1 \
	-DCARDREADER_SMARGO=1 \
	-DCARDREADER_PCSC=1 \
	-DCW_CYCLE_CHECK=1 \
	-DCS_CACHEEX=1 \
	-DMODULE_SCAM=1 \
	-DMODULE_STREAMRELAY=1 \
	"

do_install() {
	install -d ${D}/etc/tuxbox/config/ncam
	install -m 0644 ${UNPACKDIR}/ncam.* ${D}/etc/tuxbox/config/ncam/
	install -d ${D}/usr/bin
	install -m 0755 ${B}/ncam ${D}/usr/bin
}
