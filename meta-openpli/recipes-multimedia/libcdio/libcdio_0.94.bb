SUMMARY = "The GNU Compact Disc Input and Control library (libcdio) contains a library for CD-ROM and CD image access."
HOMEPAGE = "http://www.gnu.org/software/libcdio/"
SECTION = "libs"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "${GNU_MIRROR}/${BPN}/${BP}.tar.gz"

SRC_URI[md5sum] = "d8734266a20fbc2605a97b701b838ab6"
SRC_URI[sha256sum] = "96e2c903f866ae96f9f5b9048fa32db0921464a2286f5b586c0f02699710025a"

inherit autotools pkgconfig

PACKAGECONFIG ??= "cdda-player"
PACKAGECONFIG[cdda-player] = "--with-cdda-player,--without-cdda-player,ncurses"
PACKAGECONFIG[cddb] = "--enable-cddb,--disable-cddb,libcddb"
PACKAGECONFIG[vcd-info] = "--enable-vcd-info,--disable-vcd-info,vcdimager"

PACKAGES += "${PN}-utils"

FILES_${PN} = "${libdir}/${PN}${SOLIB}"
FILES_${PN} = "${libdir}/${BPN}${SOLIB}"
FILES_${PN}-utils = "${bindir}/*"

python libcdio_split_packages() {
    libdir = d.expand('${libdir}')
    do_split_packages(d, libdir, '^lib(.*)\.so\..*', 'lib%s', 'libcdio %s library', extra_depends='', allow_links=True)
}

PACKAGESPLITFUNCS =+ "libcdio_split_packages"
