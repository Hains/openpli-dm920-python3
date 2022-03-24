SUMMARY = "Ralink 88x2BU v1.0.0.9"
HOMEPAGE = "http://www.realtek.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ffa10f40b98be2c2bc9608f56827ed23"

inherit module

SRC_URI = " \
          file://rtl8822bu-driver-1.0.0.9-20180511a.zip \
          file://0001-fix-compile-with-4-7-x-kernel.patch \
          file://add-linux-4.19-support.patch \
          "

SRC_URI[md5sum] = "b5c5427f41422f0195b4947f28e877f8"
SRC_URI[sha256sum] = "09e600076691d792c2827886972c509996007c5f6dc1afe92dd66fb9ee798864"

S = "${WORKDIR}/rtl8822bu"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR}"

do_compile () {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
    oe_runmake 'M={D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless' \
        'KERNEL_SOURCE=${STAGING_KERNEL_DIR}' \
        'LINUX_SRC=${STAGING_KERNEL_DIR}' \
        'KDIR=${STAGING_KERNEL_DIR}' \
        'KERNDIR=${STAGING_KERNEL_DIR}' \
        'KSRC=${STAGING_KERNEL_DIR}' \
        'KERNEL_VERSION=${KERNEL_VERSION}' \
        'KVER=${KERNEL_VERSION}' \
        'CC=${KERNEL_CC}' \
        'AR=${KERNEL_AR}' \
        'LD=${KERNEL_LD}'
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/88x2bu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless

}

do_package_qa() {
}
