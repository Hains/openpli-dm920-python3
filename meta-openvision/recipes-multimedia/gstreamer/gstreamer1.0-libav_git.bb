require gstreamer1.0-libav.inc
include gstreamer1.0-common.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
					file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
"

SRCREV_FORMAT = "base"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gst-libav;branch=master;name=base \
			git://github.com/FFmpeg/FFmpeg.git;destsuffix=git/gst-libs/ext/libav;branch=release/4.1;name=ffmpeg \
			git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
			file://001-Disable-yasm-for-libav-when-disable-yasm.patch \
			file://002-configure-check-for-armv7ve-variant.patch \
			file://003-fix-host-contamination.patch \
"

LIBAV_EXTRA_CONFIGURE_COMMON_ARG = "--target-os=linux \
	--cc='${CC}' --as='${CC}' --ld='${CC}' --nm='${NM}' --ar='${AR}' \
	--ranlib='${RANLIB}' \
	${@bb.utils.contains('TARGET_FPU', 'soft', ' --disable-mipsfpu', ' --enable-mipsfpu', d)} \
	--disable-mipsdsp \
	--disable-mipsdspr2 \
	${GSTREAMER_1_0_DEBUG} \
	--cross-prefix='${HOST_PREFIX}'"
