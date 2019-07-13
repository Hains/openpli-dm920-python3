require linux_3.14.inc

do_configure_prepend() {
        sed -e "/^SUBLEVEL = /d" -i ${S}/Makefile
}

KERNEL_ENABLE_CGROUPS = "1"

# By default, kernel.bbclass modifies package names to allow multiple kernels
# to be installed in parallel. We revert this change and rprovide the versioned
# package names instead, to allow only one kernel to be installed.
PKG_kernel = "kernel"
PKG_${KERNEL_PACKAGE_NAME}-base = "kernel-base"
PKG_${KERNEL_PACKAGE_NAME}-image = "kernel-image"
PKG_${KERNEL_PACKAGE_NAME}-image-zimage = "kernel-image"
RPROVIDES_${KERNEL_PACKAGE_NAME} = "kernel-${LINUX_VERSION}"
RPROVIDES_${KERNEL_PACKAGE_NAME}-base = "kernel-${KERNEL_VERSION}"
RPROVIDES_${KERNEL_PACKAGE_NAME}-image = "kernel-image-${KERNEL_VERSION}"
#RPROVIDES_${KERNEL_PACKAGE_NAME}-image-zimage = "kernel-image"
RDEPENDS_${KERNEL_PACKAGE_NAME}-image = "kernel-devicetree flash-scripts"

pkg_postinst_kernel-image () {
#!/bin/sh
if [ -z "$D" ]; then
    dd if=/boot/zImage-3.14-1.17-dm920 of=/dev/mmcblk0p1
fi
}

