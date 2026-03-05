FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.1"

SRC_URI[sha256sum] = "56c1593787f8b5550893d59e4ff29e6bcccf34973316fa55e34ce493e04313a2"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
