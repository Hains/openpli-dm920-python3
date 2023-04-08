require linux_3.14.inc

KERNEL_ENABLE_CGROUPS = "1"

RPROVIDES:${KERNEL_PACKAGE_NAME} = "kernel-${LINUX_VERSION}"
RDEPENDS:${KERNEL_PACKAGE_NAME}-image = "kernel-devicetree flash-scripts"

pkg_postinst_ontarget:kernel-image () {
#!/bin/sh
    flash-kernel /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${LINUX_VERSION}
}

