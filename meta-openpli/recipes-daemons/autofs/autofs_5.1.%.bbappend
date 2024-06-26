FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

EXTRA_OECONF += "--with-confdir=/etc/default"

SRC_URI += " file://99_autofs"

CONFFILES = "${sysconfdir}/auto.master ${sysconfdir}/auto.net"

# Remove and change configuration files
do_install:append() {
	echo "/media/net /etc/auto.net --ghost" > ${D}${sysconfdir}/auto.master
	echo "# automounter configuration" > ${D}${sysconfdir}/auto.net
	chmod 0644 ${D}${sysconfdir}/auto.net
	rm -f ${D}${sysconfdir}/auto.smb ${D}${sysconfdir}/auto.misc ${D}${sysconfdir}/autofs_ldap_auth.conf
	sed -i 's/^TIMEOUT=300/TIMEOUT=30/' ${D}${sysconfdir}/default/autofs
	install -d ${D}${sysconfdir}/default/volatiles
	install -m 644 ${UNPACKDIR}/99_autofs ${D}${sysconfdir}/default/volatiles/99_autofs
}

pkg_postinst:${PN} () {
	if [ -z "$D" ]; then
		if [ ! -d /var/run/autofs ]; then
			mkdir -p /var/run/autofs
			chmod 770 /var/run/autofs
		fi
		if [ ! -d /media/net ]; then
			mkdir -p /media/net
			chmod 755 /media/net
		fi
	fi
}
