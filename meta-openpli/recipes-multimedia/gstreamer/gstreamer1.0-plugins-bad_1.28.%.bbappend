FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.3"
 
SRC_URI[sha256sum] = "4213f43ddb875bb141e5040e97735579d74665bec3d17b51052aade395b83f00"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
