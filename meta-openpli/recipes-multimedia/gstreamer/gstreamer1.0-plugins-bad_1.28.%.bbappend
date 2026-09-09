FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.7"

SRC_URI[sha256sum] = "dc525383c18b2c265bbe6a43d498656cd918aaa130aa4e3abeabcdaa741c3ffe"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
