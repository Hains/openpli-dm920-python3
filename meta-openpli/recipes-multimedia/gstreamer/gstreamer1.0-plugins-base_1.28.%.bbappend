FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.3"
 
SRC_URI[sha256sum] = "27880f3d87efa3bb5aa5f99f7ef6e4be7c95229f44eee928c1633d32e87d0099"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

CFLAGS:append = " -mthumb"

PACKAGECONFIG:append = " opus"
