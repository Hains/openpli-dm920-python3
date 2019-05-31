require gstreamer1.0-plugins-base.inc
include gstreamer1.0-common.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gst-plugins-base;branch=master;name=base \
			git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
			file://001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
			file://002-Makefile.am-prefix-calls-to-pkg-config-with-PKG_CONF.patch \
			file://003-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
			file://004-rtsp-drop-incorrect-reference-to-gstreamer-sdp-in-Ma.patch \
			file://005-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
			"
