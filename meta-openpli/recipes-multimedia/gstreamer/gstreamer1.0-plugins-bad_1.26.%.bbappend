FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.6"

SRC_URI[sha256sum] = "b3bf4b1ad3017eac1fcf1209eae8a61208f8ef43b9b1ef99b9366acf14d74a79"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
