FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.0"

SRC_URI[sha256sum] = "eace79d63bd2edeb2048777ea9f432d8b6e7336e656cbc20da450f6235758b31"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
