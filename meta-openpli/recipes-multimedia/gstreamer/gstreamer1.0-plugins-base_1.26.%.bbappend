FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.6"

SRC_URI[sha256sum] = "6e13c83be9f7746d7a5b7dbbb44882f214c3afcf32946c9a1f1bab33cc3da5a1"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
