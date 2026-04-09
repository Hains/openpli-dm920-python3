FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.2"

SRC_URI[sha256sum] = "6467e3964828f4d7d08bfe1fbb4d76287a1c8fa76674e59e101a149c020fefd7"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
