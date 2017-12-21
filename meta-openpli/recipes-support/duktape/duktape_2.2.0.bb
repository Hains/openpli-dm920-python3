DESCRIPTION = "Duktape is an embeddable Javascript engine, with a focus on portability and compact footprint."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=fddbe4ed8ac933555f193488d973da85"

SRC_URI = " \
	http://duktape.org/duktape-${PV}.tar.xz \
	file://iptvplayer.patch \
	"

SRC_URI[md5sum] = "0f7c9fac5547f7f3fc1c671fc90b2ccf"
SRC_URI[sha256sum] = "62f72206427633077cb02e7ccd2599ace4d254db409334593b86d262c0d50c14"

do_compile() {
	oe_runmake -f Makefile.cmdline
}

do_install() {
	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/IPTVPlayer/bin
	install -m 0755 ${S}/duk ${D}${libdir}/enigma2/python/Plugins/Extensions/IPTVPlayer/bin
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/IPTVPlayer/bin"
