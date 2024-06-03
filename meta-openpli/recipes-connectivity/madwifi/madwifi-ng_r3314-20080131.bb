SRCREV = "30414"
MACHINE_KERNEL_PR:append = ".${INC_PR}.3"

# versions of OpenWrt backfire (10.03)
HAL_VERSION = "20090508"

require madwifi-ng_r.inc

SRC_URI += " \
        svn://svn.openwrt.org/openwrt/trunk/package/madwifi;module=patches \
        http://mirror2.openwrt.org/sources/ath_hal-${HAL_VERSION}.tgz;name=hal \
        file://fix-target-mips32.patch \
        file://remove-wprobe.patch;apply=no \
        file://fix-module-autoload.patch;apply=no \
        file://fix-build-3.1.patch;apply=no \
        file://fix-build-3.2.patch;apply=no \
        file://ath-rate-ctlname.patch;apply=no \
        file://set-affinity-hint.patch;apply=no \
        file://workaround-high-interrupt-latency.patch;apply=no \
        file://dm8000-nand-error-hack.patch;apply=no \
        file://madwifi-smp-affinity \
        "
SRC_URI[md5sum] = "2c7352cbbdac995de8c3bce5b80db5f2"
SRC_URI[sha256sum] = "0599c75b95ba63bdc554cb8124192e62c75fbeb71b9e8a5a7bc351c8e0666758"
SRC_URI[hal.md5sum] = "4ab7ae8bdb96c0be388c98bf8f92d5ca"
SRC_URI[hal.sha256sum] = "ced93d25aea7ee43807147a0269e69a072e718d59e7dab904bbe48b900409483"

addtask postpatch after do_patch before do_configure

do_postpatch() {
        rm -rf hal
        cp -a ${UNPACKDIR}/ath_hal-${HAL_VERSION} hal
        rm -f ${UNPACKDIR}/patches/104-autocreate_none.patch
        rm -f ${UNPACKDIR}/patches/446-single_module.patch
        rm -f ${UNPACKDIR}/patches/470-mac_addresss_from_ath5k_platform_data.patch
        for i in ${UNPACKDIR}/patches/*.patch; do
                patch -p1 -i $i
        done
        patch -p1 -i ${UNPACKDIR}/remove-wprobe.patch
        patch -p1 -i ${WUNPACKDIR}/fix-module-autoload.patch
        patch -p1 -i ${UNPACKDIR}/fix-build-3.1.patch
        patch -p1 -i ${UNPACKDIR}/fix-build-3.2.patch
        patch -p1 -i ${UNPACKDIR}/ath-rate-ctlname.patch
        patch -p1 -i ${UNPACKDIR}/set-affinity-hint.patch
        patch -p1 -i ${UNPACKDIR}/workaround-high-interrupt-latency.patch
}

do_postpatch:append:dm8000() {
        patch -p1 -i ${UNPACKDIR}/dm8000-nand-error-hack.patch
}

do_install:append() {
	install -d ${D}${sysconfdir}/network/if-pre-up.d
	install -m 0755 ${UNPACKDIR}/madwifi-smp-affinity ${D}${sysconfdir}/network/if-pre-up.d
	install -d ${D}${sysconfdir}/network/if-post-down.d
	ln -sf ../if-pre-up.d/madwifi-smp-affinity ${D}${sysconfdir}/network/if-post-down.d
}
