FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.0"

SRC_URI[sha256sum] = "32d825041e5775fc9bf9e8c38e3a5c46c1441eee67f8112572450a9c23c835f0"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
