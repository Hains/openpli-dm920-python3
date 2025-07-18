SUMMARY = "tools to write DVDs"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ca43cbc842c2336e835926c2166c28b"
PR = "r4"

DEPENDS += "m4-native"
RDEPENDS:${PN} += "cdrkit"

SRC_URI = " http://downloads.openpli.org/archive/dvd+rw-tools-${PV}.tar.gz \
			file://01-growisofs-pioneer.dpatch;apply=yes \
			file://02-growisofs-manpage.dpatch;apply=yes \
			file://03-growisofs-dvd-dl.dpatch;apply=yes \
			file://04-kfreebsd.dpatch;apply=yes \
			file://07-beeping.dpatch;apply=yes \
			file://08-cdrkit-code.dpatch;apply=yes \
			file://09-cdrkit-doc.dpatch;apply=yes \
			file://10-includes.dpatch;apply=yes \
			file://11-include-sys-sysmacros.h-for-major-minor-definitions.patch;apply=yes \
			"

do_configure() {
	m4 -DOS=Linux Makefile.m4 >Makefile
}

do_compile() {
	oe_runmake CC="${CC}" CXX="${CXX}" dvd+rw-tools
}

do_install() {
	install -d ${D}${bindir}
	install -m 755 ${S}/growisofs ${D}${bindir}
	install -m 755 ${S}/dvd+rw-booktype ${D}${bindir}
	install -m 755 ${S}/dvd+rw-format ${D}${bindir}
	install -m 755 ${S}/dvd+rw-mediainfo ${D}${bindir}
	install -m 755 ${S}/dvd-ram-control ${D}${bindir}
}

SRC_URI[md5sum] = "8acb3c885c87f6838704a0025e435871"
SRC_URI[sha256sum] = "f8d60f822e914128bcbc5f64fbe3ed131cbff9045dca7e12c5b77b26edde72ca"
