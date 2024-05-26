FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.24.3"

SRC_URI[md5sum] = "4371fd500cc142be875c0ca7b24398cf"
SRC_URI[sha256sum] = "e90f26c7dc9c76f4aa599b758cfd6d8c10d6a0b9cb265ba2c3c9bdf3888558f8"

SRC_URI:append = "file://001-rtmp-hls-tsdemux-fix.patch \
                  file://003-rtmp-fix-seeking-and-potential-segfault.patch \
"
SRC_URI:remove = "file://0004-opencv-resolve-missing-opencv-data-dir-in-yocto-buil.patch"

PACKAGECONFIG = "${GSTREAMER_ORC} bz2 closedcaption curl dash dtls faac faad hls openssl opusparse \
                 rsvg rtmp sbc smoothstreaming sndfile ttml uvch264 webp \
"

EXTRA_OEMESON:remove = "-Dkate=disabled"
