SUMMARY = "Libav-based GStreamer 1.x plugin"
SECTION = "multimedia"
LICENSE = "GPLv2+ & LGPLv2+ & ( (GPLv2+ & LGPLv2.1+) | (GPLv3+ & LGPLv3+) )"
LICENSE_FLAGS = "commercial"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base ffmpeg"

inherit meson

FILES:${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES:${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES:${PN}-dev += "${libdir}/gstreamer-1.0/*.la"
FILES:${PN}-staticdev += "${libdir}/gstreamer-1.0/*.a"
