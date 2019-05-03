DESCRIPTION = "Transmission is a BitTorrent client w/ a built-in Ajax-Powered Webif GUI."
SECTION = "network"
HOMEPAGE = "www.transmissionbt.com/"
DEPENDS = "gnutls openssl libtool intltool-native curl glib-2.0-native libevent"
LICENSE = "GPLv2 & GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=0dd9fcdc1416ff123c41c785192a1895"

SRC_URI = " https://github.com/transmission/transmission-releases/raw/master/transmission-${PV}.tar.xz;name=archive \
			file://init \
			file://config \
			file://configure-kill-intl-check.patch \
			file://configure-allow-local-network.patch \
			file://configuration-default-download-dir.patch \
			"

SRC_URI[archive.md5sum] = "c92829294edfa391c046407eeb16358a"
SRC_URI[archive.sha256sum] = "35442cc849f91f8df982c3d0d479d650c6ca19310a994eccdaa79a4af3916b7d"

INITSCRIPT_NAME = "transmission"
INITSCRIPT_PARAMS = "defaults 60 "

inherit autotools update-rc.d gettext

OE_EXTRACONF = "\
	--disable-gtk --without-gtk \
	--disable-nls --without-nls \
	--disable-cli \
	--disable-mac \
	--disable-wx \
	--disable-beos \
	--enable-lightweight \
	--enable-daemon \
	CPPFLAGS=-DTR_EMBEDDED \
	"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/transmission
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/config ${D}${sysconfdir}/default/transmission-daemon
	install -d ${D}${localstatedir}/lib/transmission-daemon
}

PACKAGES += "${PN}-gui ${PN}-client"

FILES_${PN} = "${bindir}/transmission-daemon ${datadir}/transmission ${sysconfdir} ${localstatedir}/lib/${PN}-daemon"
FILES_${PN}-client = "${bindir}/transmission-remote ${bindir}/transmission-cli ${bindir}/transmission-create ${bindir}/transmission-show ${bindir}/transmission-edit"
FILES_${PN}-gui += "${bindir}/transmission-gtk ${datadir}/icons ${datadir}/applications ${datadir}/pixmaps"
CONFFILES_${PN} = "${sysconfdir}/default/transmission-daemon"
