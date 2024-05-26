FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.24.3"

SRC_URI[md5sum] = "61e077e4ca35e306d45fef24337db2ca"
SRC_URI[sha256sum] = "f1094397eaa7932f06e57ebbb075aa33aa2c76e4b75630a16b02c8d4af46832e"

SRC_URI:append = " file://001-riff-media-added-fourcc-to-all-ffmpeg-mpeg4-video-caps.patch \
                   file://002-subparse-avoid-false-negatives-dealing-with-UTF-8.patch \
"

PACKAGECONFIG = "${GSTREAMER_ORC} alsa jpeg ogg opus pango png theora vorbis"
