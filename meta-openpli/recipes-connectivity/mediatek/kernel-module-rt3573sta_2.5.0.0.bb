SUMMARY = "Ralink 3573 v2.5.0.0"
HOMEPAGE = "http://www.realtek.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://iwpriv_usage.txt;md5=8876ae2c103446a442658f1cc2a01b76"

inherit module

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " \
          file://20120911_RT3573_Linux_STA_v2.5.0.0_Rev4_DPO.tar.gz \
          file://remove_linux_2_4_compability.patch \
          "

SRC_URI[md5sum] = "08256c9b2ae77308b608662dc0ba3a1b"
SRC_URI[sha256sum] = "d3422502e09020bd6909aa63be87747604de976a312c3d38c811b6cf6ac84fe9"

FILES:${PN}:append = "${sysconfdir}/Wireless"

S = "${UNPACKDIR}/20120911_RT3573_Linux_STA_v2.5.0.0_Rev4_DPO"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/os/linux/rt3573sta.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -d ${D}${sysconfdir}/Wireless/RT3573STA
    install -m 0644 ${S}/RT2870STA.dat ${D}${sysconfdir}/Wireless/RT3573STA/RT3573STA.dat
    install -m 0644 ${S}/RT2870STACard.dat ${D}${sysconfdir}/Wireless/RT3573STA/RT3573STACard.dat
}



