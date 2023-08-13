DESCRIPTION = "Free portable AirPlay server implementation"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7fff59c88f17faa814f26f26b06a7100"

PR = "r1"

inherit autotools pkgconfig

SRC_URI = "git://github.com/juhovh/shairplay.git;protocol=https;branch=master \
           file://remove-dns-sd-h-header-file-check.patch \
"

S = "${WORKDIR}/git"

do_install:append(){
    install -d ${D}/${includedir}/shairplay
    install -m 0644 ${S}/include/shairplay/*.h ${D}/${includedir}/shairplay/
}

FILES:${PN} += "${libdir}/*.so ${includedir}/shairplay/*.h"
