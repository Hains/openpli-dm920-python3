FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.5"

SRC_URI[sha256sum] = "d8af55faef2958c1a8663751475ee46f5164877cf4d8c5913ea906ef180aeb71"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
