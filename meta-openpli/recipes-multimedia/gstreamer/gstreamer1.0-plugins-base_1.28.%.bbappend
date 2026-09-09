FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.7"

SRC_URI[sha256sum] = "ed6e5410f496d171818763af2265e7977154bc7f9b827e98acf8c5bed21dd5a7"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
                   file://0001-audio-resampler-neon.h-Remove-character-w-in-type-sp.patch \
"

PACKAGECONFIG:append = " opus"
