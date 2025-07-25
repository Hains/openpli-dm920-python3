MAINTAINER = "Narcis Ilisei"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

PV = "v.02.24.44"
PR = "r3"

SRC_URI = "https://sourceforge.net/projects/${BPN}/files/${BPN}/${BPN}.${PV}/${BPN}.${PV}.tar.gz \
	file://inadyn-mt.sh \
	file://inadyn.conf \
	file://remove_host_include_paths.patch \
	file://inadyn-mt-ip6-127.0.0.1-00-02.24.44.patch \
	file://fix-build-with-gcc15.patch \
	"

SRC_URI[md5sum] = "0652d99aab1249d6a3afe4d65861e77b"
SRC_URI[sha256sum] = "f894b5ab92ed4ec4cae2eccc99efef1aa18c0f5f02de66025e50833cc9063c3c"

S = "${UNPACKDIR}/${BPN}.${PV}"

inherit autotools-brokensep update-rc.d

INITSCRIPT_NAME = "inadyn-mt"
CONFFILES:${PN} = "${sysconfdir}/inadyn.conf"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	make -f makefile-deprecated
}

do_install() {
	install -d ${D}${bindir}
	install -m 755 ${B}/bin/linux/inadyn-mt ${D}${bindir}
	install -d ${D}${sysconfdir}
	install -m 644 ${UNPACKDIR}/inadyn.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/inadyn-mt.sh ${D}${sysconfdir}/init.d/inadyn-mt
}
