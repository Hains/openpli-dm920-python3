FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.1"

SRC_URI[sha256sum] = "1446a4c2a92ff5d78d88e85a599f0038441d53333236f0c72d72f21a9c132497"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
