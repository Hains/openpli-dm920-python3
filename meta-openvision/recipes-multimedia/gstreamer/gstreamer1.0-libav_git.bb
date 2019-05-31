require gstreamer1.0-libav.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
					file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
					"

SRCREV_FORMAT = "base"

SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-libav;branch=master;name=base"
SRC_URI += "file://0001-Disable-yasm-for-libav-when-disable-yasm.patch"

S = "${WORKDIR}/git"

inherit gitpkgv

GST_VERSION_FULL = "1.17.0.1"
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"

LIBAV_EXTRA_CONFIGURE_COMMON_ARG = "--target-os=linux \
	--cc='${CC}' --as='${CC}' --ld='${CC}' --nm='${NM}' --ar='${AR}' \
	--ranlib='${RANLIB}' \
	${@bb.utils.contains('TARGET_FPU', 'soft', ' --disable-mipsfpu', ' --enable-mipsfpu', d)} \
	--disable-mipsdsp \
	--disable-mipsdspr2 \
	${GSTREAMER_1_0_DEBUG} \
	--cross-prefix='${HOST_PREFIX}'"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}
