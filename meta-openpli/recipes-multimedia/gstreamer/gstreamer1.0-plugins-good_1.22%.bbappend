FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.22.12"

SRC_URI[md5sum] = "29c40634af218e43b373859aa19e2833"
SRC_URI[sha256sum] = "9c1913f981900bd8867182639b20907b28ed78ef7a222cfbf2d8ba9dab992fa7"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG = "${GSTREAMER_ORC} bz2 cairo flac gdk-pixbuf gudev jpeg lame libpng \
                 mpg123 soup3 speex taglib v4l2 vpx wavpack \
"
