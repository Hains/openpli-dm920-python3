DESCRIPTION = "A Linux file system driver that allows you to mount a WebDAV server as a disk drive."
SECTION = "network"
PRIORITY = "optional"
HOMEPAGE = "http://dav.sourceforge.net"
DEPENDS = "virtual/gettext neon"
RRECOMMENDS:${PN} = "kernel-module-coda"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"

PR = "r0"

SRC_URI[md5sum] = "c9f0b557275b7ec88fec751bf22f30cf"
SRC_URI[sha256sum] = "c9c4e0f0912a782386216b2147eb9c36c47f193b8fcf3d637719e0b9fe7c96e0"

SRC_URI = "http://download.savannah.nongnu.org/releases/davfs2/${P}.tar.gz \
           file://neon-config \
           file://volatiles \
           file://davfs2.cfg \
           file://make-integer-extern.patch \
"

inherit autotools pkgconfig useradd gettext

USERADD_PACKAGES = "davfs2"
USERADD_PARAM:davfs2 = "--system --home /var/run/mount.davfs \
                        --no-create-home --shell /bin/false \
                        --user-group davfs2"

EXTRA_OECONF = "--with-neon \
                ac_cv_path_NEON_CONFIG=${WORKDIR}/neon-config"


CONFFILES:${PN} = "${sysconfdir}/davfs2/davfs2.conf ${sysconfdir}/davfs2/secrets"

do_install:prepend () {
	cp ${WORKDIR}/davfs2-${PV}/etc/davfs2.conf ${WORKDIR}/build/etc
	cp ${WORKDIR}/davfs2-${PV}/etc/secrets ${WORKDIR}/build/etc
}

do_install:append () {
        mkdir -p ${D}${sysconfdir}/default/volatiles
        install -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/10_davfs2
        rm -rf ${D}${datadir}/davfs2
}
