FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.1"

SRC_URI[sha256sum] = "659553636f84dcf388cad5cf6530e02b0b2d3dc450e76199287ba9db6a6c5226"


SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"
SRC_URI:remove = "file://0001-gstreamer1.0-plugins-base-Fix-atomic-64-issue-on-arm.patch"

PACKAGECONFIG:append = " opus"
