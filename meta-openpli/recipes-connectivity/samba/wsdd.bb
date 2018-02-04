SUMMARY = "WS-Discovery daemon"
DESCRIPTION = "Anounces a device to Windows via WSD"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "util-linux samba"

SRC_URI = " \
	file://Makefile \
	file://wsdd.c \
	"

PR = "r1"
PV = "1.0"

S = "${WORKDIR}"

do_compile() {
    make -f Makefile
}

do_install() {
    install -d ${D}/${sbindir}
    install -m 755 ${S}/wsdd ${D}/${sbindir}
}
