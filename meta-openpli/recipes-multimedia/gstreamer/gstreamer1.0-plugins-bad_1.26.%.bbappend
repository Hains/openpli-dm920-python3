FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.1"

SRC_URI[sha256sum] = "9b8415b1bb3726a499578fb39907952981716643f660215fe68628fbd8629197"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"
SRC_URI:remove = "file://0001-backport-libatomic-issue-patch.patch"

PACKAGECONFIG:append = " faac faad opusparse rtmp"
