DESCRIPTION = "Driver for Realtek USB wireless devices"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"

LIC_FILES_CHKSUM = "file://README.md;md5=ca170803f8c67c0af58fc5dfbfc76863"

inherit module machine_kernel_pr

SRC_URI = "git://github.com/lwfinger/rtl8188eu.git;branch=master;protocol=https"

S = "${WORKDIR}/git"

MACHINE_KERNEL_PR:append = ".0"

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/8188eu.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}

