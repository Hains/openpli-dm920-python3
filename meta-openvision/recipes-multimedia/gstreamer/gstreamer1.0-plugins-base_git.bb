require gstreamer1.0-plugins-base.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d"

SRCREV_FORMAT = "base"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gst-plugins-base;branch=master;name=base \
			git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
			"

SRC_URI += "file://001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
			file://002-Makefile.am-prefix-calls-to-pkg-config-with-PKG_CONF.patch \
			file://003-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
			file://004-rtsp-drop-incorrect-reference-to-gstreamer-sdp-in-Ma.patch \
			file://005-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
			"

S = "${WORKDIR}/git"

inherit gitpkgv

GST_VERSION_FULL = "1.17.0.1"
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}
