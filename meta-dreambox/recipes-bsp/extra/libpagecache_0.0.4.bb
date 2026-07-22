SUMMARY = "Preloadable library to improve large file operations"
SECTION = "base"
LICENSE = "LicenseRef-LICENSE-CLOSED"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/LICENSE-CLOSED;md5=2d5b03b35d4612637d67724b35738dd7"

DEPENDS = "libdlsym"

SRCREV = "6e7b3136e17c28697b3dcea597a334022a931b27"

inherit autotools opendreambox-git pkgconfig

FILES:${PN} = "${libdir}/lib*${SOLIBSDEV}"
FILES_SOLIBSDEV = ""

RREPLACES:${PN} += "libpagecache0"
RCONFLICTS:${PN} += "libpagecache0"

pkg_postinst:${PN} () {
[ -z $D ] && sed -i 's|${libdir}/libpagecache.so.0.0.0||g' ${sysconfdir}/ld.so.preload || /bin/true
}

pkg_postrm:${PN} () {
[ -z $D ] && sed -i 's|${libdir}/libpagecache.so.0.0.0||g' ${sysconfdir}/ld.so.preload || /bin/true
}
