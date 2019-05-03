SUMMARY = "MJPEG video capture/editting/playback MPEG encoding"
HOMEPAGE = "http://sourceforge.net/projects/mjpeg/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
DEPENDS = "jpeg libpng"

SRC_URI = "https://sourceforge.net/projects/mjpeg/files/mjpegtools/${PV}/${BP}.tar.gz"

SRC_URI[md5sum] = "57bf5dd78976ca9bac972a6511b236f3"
SRC_URI[sha256sum] = "864f143d7686377f8ab94d91283c696ebd906bf256b2eacc7e9fb4dddcedc407"

inherit autotools pkgconfig

EXTRA_OECONF = " \
        --without-libquicktime \
        --without-libdv \
        --without-dga \
        --without-gtk \
        --without-libsdl \
        --without-v4l \
        --without-x \
"
