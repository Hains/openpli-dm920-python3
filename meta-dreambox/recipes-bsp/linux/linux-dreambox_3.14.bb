inherit kernel machine_kernel_pr siteinfo

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "dm920"

MACHINE_KERNEL_PR:append = "4"

PATCHLEVEL = "79"

SRC_URI = " \
	${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-${PV}.tar.xz;name=kernel \
	${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-${PV}.${PATCHLEVEL}.xz;apply=yes;name=stable-patch \
	file://linux-dreambox-3.14.patch.xz \
	file://0001-Support-TBS-USB-drivers.patch \
	file://0002-STV-Add-PLS-support.patch \
	file://0003-STV-Add-SNR-Signal-report-parameters.patch \
	file://0004-stv090x-optimized-TS-sync-control.patch \
	file://0005-genksyms_fix_typeof_handling.patch \
	file://0006-blindscan2.patch \
	file://0007-overlayfs.patch \
	file://0008-tuners-tda18273-silicon-tuner-driver.patch \
	file://0009-si2157-Silicon-Labs-Si2157-silicon-tuner-driver.patch \
	file://0010-si2168-Silicon-Labs-Si2168-DVB-T-T2-C-demod-driver.patch \
	file://0011-cxusb-Geniatech-T230-support.patch \
	file://0012-CONFIG_DVB_SP2.patch \
	file://0013-dvbsky.patch \
	file://0014-rtl2832u-2.patch \
	file://0015-log2-give-up-on-gcc-constant-optimizations.patch \
	file://0016-uaccess-dont-mark-register-as-const.patch \
	file://0017-makefile-silence-packed-not-aligned-warn.patch \
	file://0018-make-yyloc-global-declaration-extern.patch \
	file://0019-fix-build-binutils241.patch \
	file://defconfig \
"

SRC_URI[kernel.md5sum] = "b621207b3f6ecbb67db18b13258f8ea8"
SRC_URI[kernel.sha256sum] = "61558aa490855f42b6340d1a1596be47454909629327c49a5e4e10268065dffa"
SRC_URI[stable-patch.md5sum] = "c2bc200bf9eb5a49e2137e039ea27884"
SRC_URI[stable-patch.sha256sum] = "b391b76f3a5c6c8cf7234f8c01821b88584ddf90f45323e09c126c5e7624b12c"
SRC_URI[dream-patch.md5sum] = "b8e267850e54a1d13be41456be5ec4b5"
SRC_URI[dream-patch.sha256sum] = "85a18df9f07e221c0fd305cc213e5557d9006a40b3229bf9d13e5bc9ba8e2371"

require linux-dreambox_3.14.inc

S = "${UNPACKDIR}/linux-${PV}"
B = "${UNPACKDIR}/build"

CMDLINE = "bmem=640M@384M bmem=384M@2048M console=ttyS0,1000000 root=/dev/mmcblk0p2 rootwait rootfstype=ext4 coherent_pool=2M"

DEFCONFIG = "${MACHINE}"

BRCM_PATCHLEVEL = "1.17"

LINUX_VERSION = "${PV}-${BRCM_PATCHLEVEL}-${MACHINE}"
KERNEL_IMAGETYPE = "zImage"
KERNEL_DEVICETREE = "dreambox-dm900.dtb"

do_rm_work() {
}
