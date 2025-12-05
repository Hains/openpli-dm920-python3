FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.9"

SRC_URI[sha256sum] = "11db4ec9ae5be2194ff8ccf2b5fecdc069252fe4416921b083a921ef71dd000a"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
