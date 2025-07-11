SUMMARY = "Tools for the Linux Standard Wireless Extension Subsystem"
HOMEPAGE = "https://hewlettpackard.github.io/wireless-tools/Tools.html"
LICENSE = "GPL-2.0-only & (LGPL-2.1-only | MPL-1.1 | BSD-3-Clause)"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
			file://iwconfig.c;beginline=1;endline=12;md5=cf710eb1795c376eb10ea4ff04649caf \
			file://iwevent.c;beginline=59;endline=72;md5=d66a10026d4394f0a5b1c5587bce4537 \
			file://sample_enc.c;beginline=1;endline=4;md5=838372be07874260b566bae2f6ed33b6"
SECTION = "base"
PE = "1"

SRC_URI = "https://hewlettpackard.github.io/wireless-tools/wireless_tools.${PV}.tar.gz \
           file://remove.ldconfig.call.patch \
           file://man.patch \
           file://avoid_strip.patch \
           file://ldflags.patch \
          "
SRC_URI[md5sum] = "ca91ba7c7eff9bfff6926b1a34a4697d"
SRC_URI[sha256sum] = "abd9c5c98abf1fdd11892ac2f8a56737544fe101e1be27c6241a564948f34c63"

UPSTREAM_CHECK_URI = "https://hewlettpackard.github.io/wireless-tools/Tools.html"
UPSTREAM_CHECK_REGEX = "wireless_tools\.(?P<pver>(\d+)(\..*|))\.tar\.gz"

S = "${UNPACKDIR}/wireless_tools.30"

CFLAGS =+ "-I${S}"
EXTRA_OEMAKE = "-e 'BUILD_SHARED=y' \
		'INSTALL_DIR=${D}${base_sbindir}' \
		'INSTALL_LIB=${D}${libdir}' \
		'INSTALL_INC=${D}${includedir}' \
		'INSTALL_MAN=${D}${mandir}'"

do_compile() {
	oe_runmake all libiw.a
}

do_install() {
	oe_runmake PREFIX=${D} install-iwmulticall install-dynamic install-man install-hdr
	install -d ${D}${sbindir}
	install -m 0755 ifrename ${D}${sbindir}/ifrename
}

PACKAGES = "libiw libiw-dev libiw-doc ifrename-doc ifrename ${PN} ${PN}-doc ${PN}-dbg"

FILES:libiw = "${libdir}/*.so.*"
FILES:libiw-dev = "${libdir}/*.a ${libdir}/*.so ${includedir}"
FILES:libiw-doc = "${mandir}/man7"
FILES:ifrename = "${sbindir}/ifrename"
FILES:ifrename-doc = "${mandir}/man8/ifrename.8 ${mandir}/man5/iftab.5"
FILES:${PN} = "${bindir} ${sbindir}/iw* ${base_sbindir} ${base_bindir} ${sysconfdir}/network"
FILES:${PN}-doc = "${mandir}"
