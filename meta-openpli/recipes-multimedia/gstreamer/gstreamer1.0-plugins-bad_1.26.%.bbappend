FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.8"


SRC_URI[sha256sum] = "25c05be5eb0694bde3ecd3317516f5d0d6e4ad21125a5ebcf6fb644a4c92439f"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
