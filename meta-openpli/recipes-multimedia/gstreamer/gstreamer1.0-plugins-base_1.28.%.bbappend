FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.5"

SRC_URI[sha256sum] = "776f19228f91fd25bbf54d9850597e158507f594872a52b9b6814e2429b43eaa"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
                   file://0001-audio-resampler-neon.h-Remove-character-w-in-type-sp.patch \
"

PACKAGECONFIG:append = " opus"
