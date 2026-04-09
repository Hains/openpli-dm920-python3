FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.2"

SRC_URI[sha256sum] = "4db76b3619280037a4047de7d9dbb38613a4272dcc40efb333257124635a888d"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
