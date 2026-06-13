FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.4"
 
SRC_URI[sha256sum] = "a898afd5766172b0049e6781558e0689098bf87b9d82b846c652e571c01d60d8"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
                   file://0001-audio-resampler-neon.h-Remove-character-w-in-type-sp.patch \
"

PACKAGECONFIG:append = " opus"
