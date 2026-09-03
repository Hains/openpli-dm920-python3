FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
                   file://0001-audio-resampler-neon.h-Remove-character-w-in-type-sp.patch \
"

PACKAGECONFIG:append = " opus"
