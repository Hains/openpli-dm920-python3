SUMMARY = "Dhrystone CPU benchmark for Open Vision"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/PD;md5=b3597d12946881e13cb3b548d1173851"

SRC_URI = "file://dhry-openvision.zip"

S = "${WORKDIR}/dhry-openvision"

# Need to override Makefile variables
EXTRA_OEMAKE = "-e MAKEFLAGS="

inherit autotools-brokensep

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/dhry ${D}${bindir}
}

# Prevent procedure merging as required by dhrystone.c:
CFLAGS += "-fno-lto"

LDFLAGS += "-fno-lto"
