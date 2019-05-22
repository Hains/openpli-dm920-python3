DEFAULT_PREFERENCE = "1"

include gstreamer1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
					file://gst/gst.h;beginline=1;endline=21;md5=e059138481205ee2c6fc1c079c016d0d \
					"

SRCREV_FORMAT = "base"

SRC_URI = " git://anongit.freedesktop.org/gstreamer/gstreamer;branch=master;name=base \
			git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
			"

SRC_URI += "file://001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
			file://003-revert-use-new-gst-adapter-get-buffer.patch \
			file://004-Revert-plugin-Unify-static-and-dynamic-plugin-interface.patch \
			file://005-fix-build.patch \
			"

S = "${WORKDIR}/git"

inherit gitpkgv

GST_VERSION_FULL = "1.17.0.1"
PV = "${GST_VERSION_FULL}+git${SRCPV}"
PKGV = "${GST_VERSION_FULL}+git${GITPKGV}"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}
