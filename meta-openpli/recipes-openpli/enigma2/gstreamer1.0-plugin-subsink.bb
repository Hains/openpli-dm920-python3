DESCRIPTION = "gstreamer subsink plugin"
SECTION = "multimedia"
PRIORITY = "optional"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base glib-2.0 glib-2.0-native"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

GITHUB_URI ?= "git://github.com"
SRC_URI = "${GITHUB_URI}/OpenPLi/gst-plugin-subsink.git;protocol=https;branch=master \
           file://drop-unused-gst-plugin-cvs-macro.patch \
           file://drop-superfluous-gst-error-macro.patch \
"

inherit autotools pkgconfig gitpkgv

GSTVERSION = "1.0"

PV = "${GSTVERSION}+git"
PKGV = "${GSTVERSION}+git${GITPKGV}"

EXTRA_OECONF = "--with-gstversion=${GSTVERSION}"

FILES:${PN} = "${libdir}/gstreamer-${GSTVERSION}/*.so*"
FILES:${PN}-dev += "${libdir}/gstreamer-${GSTVERSION}/*.la"
FILES:${PN}-staticdev += "${libdir}/gstreamer-${GSTVERSION}/*.a"
FILES:${PN}-dbg += "${libdir}/gstreamer-${GSTVERSION}/.debug"

