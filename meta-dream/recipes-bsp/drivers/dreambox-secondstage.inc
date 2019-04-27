SUMMARY = "Dreambox second stage bootloader"
SECTION = "base"
LICENSE = "CLOSED"
PROVIDES += "virtual/bootloader"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "http://dreamboxupdate.com/download/opendreambox/2.2.0/dreambox-secondstage/${PV}/${MACHINE}/${MD5SUM}/dreambox-secondstage_${PV}_${MACHINE}.tar.xz;name=${MACHINE}"

PACKAGES = "${PN}"

S = "${WORKDIR}/dreambox-secondstage_${PV}_${MACHINE}"

do_install() {
    install -d ${D}/usr/share/dreambox-secondstage
    install -m 0644 ${S}/usr/share/dreambox-secondstage/ssbl.bin ${D}/usr/share/dreambox-secondstage/ssbl.bin
}

RDEPENDS_${PN} = "flash-scripts"
FILES_${PN} = "/usr/share/dreambox-secondstage/ssbl.bin"
