FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.0"

SRC_URI[sha256sum] = "e23189fbed2ec486690382d1055c19eeaf5aae3e95e2576fc4c884d96a90e69e"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
