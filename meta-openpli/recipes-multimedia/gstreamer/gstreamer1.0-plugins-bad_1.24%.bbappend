FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.0"

SRC_URI[sha256sum] = "f8287a84c5f66368a5a50da5f969994a02c47f20220ffe1ca3154193e65af216"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
