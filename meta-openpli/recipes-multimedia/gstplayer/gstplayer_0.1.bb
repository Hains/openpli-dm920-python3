DESCRIPTION = "gstplayer by samsamsam"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"

inherit pkgconfig

SRC_URI = "git://github.com/OpenVisionE2/gstplayer.git;protocol=http;branch=master"

S = "${WORKDIR}/git"

do_compile() {
	cd ${S}/gst-1.0
	${CC} *.c ../common/*.c -I../common/ `pkg-config --cflags --libs gstreamer-1.0 gstreamer-pbutils-1.0` -o gstplayer_gst-1.0 ${LDFLAGS}
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/gst-1.0/gstplayer_gst-1.0 ${D}${bindir}/gstplayer
}

pkg_postinst:${PN}() {
	ln -sf gstplayer $D${bindir}/gstplayer_gst-1.0
}

pkg_prerm:${PN}() {
	rm -f $D${bindir}/gstplayer_gst-1.0
}
