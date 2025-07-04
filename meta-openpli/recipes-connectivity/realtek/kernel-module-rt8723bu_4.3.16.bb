DESCRIPTION = "Driver for Realtek USB wireless devices"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://README.md;md5=7c7799e38fb24c3c8a114bac8e2517de"

# backward compatibility
RPROVIDES_${PN} = "rtl8723bu"

inherit module

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = " \
          git://github.com/lwfinger/rtl8723bu.git;protocol=https;branch=master \
          file://rt8723bu-makefile.patch \
          file://rt8723bu-gcc5.patch \
          "

MACHINE_KERNEL_PR:append = ".0"

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/8723bu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}

