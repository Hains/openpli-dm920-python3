# version
PR = "r1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

# Remove acl, cups etc. support.
PACKAGECONFIG_remove = "acl cups"

EXTRA_OECONF += " \
			--with-ads \
			--with-sockets-dir=${localstatedir}/run \
			--with-logfilebase=${localstatedir}/log/samba \
			--without-ad-dc \
			--without-dnsupdate \
			--without-profiling-data \
			--without-quotas \
			--without-syslog \
			--without-winbind \
			--disable-iprint \
			--disable-python \
			--nopyc \
			"

EXTRA_OECONF_remove = " \
			--with-profiling-data \
			--with-sockets-dir=/run/samba \
			"

# Remove unused, add own config, init script
SRC_URI += " \
			file://smb.conf \
			file://samba.sh \
			file://users.map \
			file://pam \
			"

FILES_${PN}-base += "${sysconfdir}/init.d/samba.sh \
					 ${bindir}/testparm \
					 ${bindir}/smbpasswd \
					 ${bindir}/smbstatus \
					 "

RRECOMMENDS_${PN}-base+= "wsdd"

do_install_prepend() {
	install -d ${D}${sysconfdir}/sudoers.d
}

do_configure_prepend() {
	perl -i -pe 's#lp_private_dir#lp_pid_directory#' ${S}/source3/lib/messages.c
}

do_install_append() {
	rm -fR ${D}/var
	rm -fR ${D}/run
	rm -fR ${D}${sysconfdir}/tmpfiles.d
	rm -fR ${D}${sysconfdir}/sysconfig
	rm -f ${D}${sysconfdir}/init.d/samba
	install -d ${D}${sysconfdir}/pam.d
	install -m 644 ${WORKDIR}/pam ${D}${sysconfdir}/pam.d/samba
	install -d ${D}${sysconfdir}/samba
	install -m 644 ${WORKDIR}/smb.conf ${D}${sysconfdir}/samba
	install -m 755 ${WORKDIR}/samba.sh ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/samba/private
	install -m 644 ${WORKDIR}/users.map ${D}${sysconfdir}/samba/private
}

pkg_postinst_${BPN}-common_prepend() {
#!/bin/sh

if [ -z "$D" ]; then
	[ -e /etc/samba/private/smbpasswd ] || touch /etc/samba/private/smbpasswd
	grep -qE '^root:' /etc/samba/private/smbpasswd
	if [[ $? -ne 0 ]] ; then
		smbpasswd -Lan root >/dev/null
        fi
fi
}

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}-base"
INITSCRIPT_NAME_${PN}-base = "samba.sh"
INITSCRIPT_PARAMS_${PN}-base = "defaults"

CONFFILES_${BPN}-base = "${sysconfdir}/samba/smb.conf"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# remove libnetapi package witch contains a lot of cross dependencies from libsamba-base
PACKAGES_remove = "libnetapi"

# move config file to samba-base
FILES_${PN}-base += "${sysconfdir}/samba/smb.conf"

# move all libraries from samba to libsamba-base to fix circular dependencies
FILES_lib${PN}-base += "\
					${libdir}/*.so.* \
					${libdir}/samba/*.so \
					${libdir}/samba/*.so.* \
					"

# move some libraries from libsamba-base to libwbclient to fix circular dependencies
FILES_libwbclient ="${libdir}/libwbclient.so.* \
					${libdir}/samba/libwinbind-client.so \
					${libdir}/samba/libwinbind-client-samba4.so \
					${libdir}/samba/libreplace-samba4.so \
					"
