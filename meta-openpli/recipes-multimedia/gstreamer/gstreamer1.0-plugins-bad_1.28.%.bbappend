FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.4"
 
SRC_URI[sha256sum] = "332b7320f30c60f2d5941446d03b9d05e3781f2c2561befbe88718bd777f0e47"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
