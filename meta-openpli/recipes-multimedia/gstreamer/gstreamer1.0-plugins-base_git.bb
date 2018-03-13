DEFAULT_PREFERENCE = "1"

include gstreamer1.0-plugins-base.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=c54ce9345727175ff66d17b67ff51f58 \
					file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
					"

SRCREV_FORMAT = "base"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gst-plugins-base;branch=master;name=base \
			git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
			"

SRC_URI += "file://001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
			file://002-Makefile.am-don-t-hardcode-libtool-name-when-running.patch \
			file://003-Makefile.am-prefix-calls-to-pkg-config-with-PKG_CONF.patch \
			file://004-riff-add-missing-include-directories-when-calling-in.patch \
			file://005-rtsp-drop-incorrect-reference-to-gstreamer-sdp-in-Ma.patch \
			file://006-get-caps-from-src-pad-when-query-caps.patch \
			file://007-taglist-not-send-to-down-stream-if-all-the-frame-cor.patch \
			file://008-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
			file://009-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
			file://010-make-gio_unix_2_0-dependency-configurable.patch \
			"

S = "${WORKDIR}/git"

inherit gitpkgv

GST_VERSION_FULL = "1.13.91"
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}
