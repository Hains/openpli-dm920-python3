require gstreamer1.0.inc
require gstreamer1.0-common.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=69333daa044cb77e486cc36129f7a770"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gstreamer;branch=master \
			file://001-revert-use-new-gst-adapter-get-buffer.patch \
"
