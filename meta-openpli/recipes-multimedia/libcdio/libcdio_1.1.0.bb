SUMMARY = "The GNU Compact Disc Input and Control library (libcdio) contains a library for CD-ROM and CD image access."
HOMEPAGE = "http://www.gnu.org/software/libcdio/"
SECTION = "libs"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = " ${GNU_MIRROR}/${BPN}/${BP}.tar.gz \
			file://dont-free-cdtext.patch \
"

SRC_URI[md5sum] = "87867d41b807c73a11d368a346a26a68"
SRC_URI[sha256sum] = "785c32494e4770c38bef09b1a545ef3acec8ccfbf2b799cb7e70dc380cbcf164"

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
