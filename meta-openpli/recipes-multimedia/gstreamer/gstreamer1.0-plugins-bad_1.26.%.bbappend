FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.7"


SRC_URI[sha256sum] = "a0ab17dddd4c029ecd7a423c30badd5a3c7599ea42707016d1d57545f5723ccf"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
