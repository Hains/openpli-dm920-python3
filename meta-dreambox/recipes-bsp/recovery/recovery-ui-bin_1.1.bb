SUMMARY = "Simple user interface for Dreambox rescue mode"
HOMEPAGE = "http://dreamboxupdate.com/"
LICENSE = "CLOSED"
DEPENDS = "libmnl xz libnexus-ui"
PROVIDES = "recovery-ui"

inherit opendreambox-precompiled-binary update-rc.d

SRC_URI[md5sum] = "b8c5ce8c4047360382609a80fec85d5e"
SRC_URI[sha256sum] = "9c75d63d3edebad946c92bab2f72f73513505b24dc95442c82ef04894ff3d12a"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PRECOMPILED_ARCH = "dm900"

RRECOMMENDS:${PN} = "dreambox-dvb-modules-${MACHINE}-lcd"
RPROVIDES:${PN} = "recovery-ui"

INITSCRIPT_NAME = "recovery-ui"

PRECOMPILED_NAME = "recovery-ui"
