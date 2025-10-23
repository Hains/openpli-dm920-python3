FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.7"

SRC_URI[sha256sum] = "969e3cbf05dfab92cf37e94840fbe398517d7ba3275331d1c216a2e30a7208d0"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG:append = " opus"
