require gstreamer1.0-plugins-base.inc
include gstreamer1.0-common.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=69333daa044cb77e486cc36129f7a770"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gst-plugins-base;branch=master \
			file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
			file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"
