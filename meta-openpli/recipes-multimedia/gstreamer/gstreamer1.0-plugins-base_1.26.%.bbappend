FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.8"

SRC_URI[sha256sum] = "513cace4b02cb183ee47665d64bb2a25088abb6678c4cc57bb100b841add746b"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
