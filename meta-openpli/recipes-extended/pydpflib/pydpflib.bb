ESCRIPTION = "Tools for managing memory technology devices."
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${S}/README;md5=42a667e310028ad2cc31da2ae54d8f16"

DEPENDS = "libusb-compat libusb1 python3"

SRC_URI = "git://github.com/atvcaptain/dpf-ax.git;branch=dreamlayers;protocol=https \
          file://set-python-version-to-313.patch \
          file://replace-py-ty-with-py--set-type.patch \
          file://fix-incompatible-pointer-type.patch \
          file://migrate-to-new-buffer-protocol.patch \
"

inherit pkgconfig gitpkgv python3native

SRCREV = "${AUTOREV}"
PV = "4.0.+git"
PKGV = "4.0.+git${GITPKGV}"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

EXTRA_OEMAKE = "'CC=${CC}' 'CFLAGS=${CFLAGS} -I${S}include -I${S}src 'BUILDDIR=${S}'"

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF = " \
        BUILD_SYS=${BUILD_SYS} \
        HOST_SYS=${HOST_SYS} \
        STAGING_INCDIR=${STAGING_INCDIR} \
        STAGING_LIBDIR=${STAGING_LIBDIR} \
        DEVLIB=${S} \
"

do_configure:prepend() {
    export BUILD_SYS=${BUILD_SYS}
    export HOST_SYS=${HOST_SYS}
    export STAGING_INCDIR=${STAGING_INCDIR}
    export STAGING_LIBDIR=${STAGING_LIBDIR}
    export DEVLIB=${S}
}

do_compile:prepend() {
    export BUILD_SYS=${BUILD_SYS}
    export HOST_SYS=${HOST_SYS}
    export STAGING_INCDIR=${STAGING_INCDIR}
    export STAGING_LIBDIR=${STAGING_LIBDIR}
    export DEVLIB=${S}
}

do_compile() {
    make -f ${S}/Makefile default
}

FILES:${PN} = "${libdir}"

do_install() {
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/LCD4linux
    install -m 644 ${S}/python/Debug/libdpf.so ${D}${libdir}//enigma2/python/Plugins/Extensions/LCD4linux/dpflib.so
}
