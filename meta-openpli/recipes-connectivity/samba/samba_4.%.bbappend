# version
PR = "r3"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Remove acl, cups etc. support.
PACKAGECONFIG:remove = "acl cups"

EXTRA_OECONF += " \
			--with-ads \
			--with-sockets-dir=${localstatedir}/run \
			--with-logfilebase=${localstatedir}/log/samba \
			--without-profiling-data \
			--without-quotas \
			--without-syslog \
			--without-winbind \
			--disable-iprint \
			--nopyc \
			"

SRC_URI += " \
			file://smb.conf \
			file://smb-secure.conf \
			file://smb-user.conf \
			file://pam.config \
			file://samba.sh \
			file://users.map \
			file://smbpasswd \
			file://share.template \
			file://0001-Revert-pam_smbpass-REMOVE-this-PAM-module.patch \
			file://0002-Revert-source3-wscript-remove-pam_smbpass-option-as-it-was-removed.patch \
			file://0003-dynamically-create-a-samba-account-if-needed.patch \
			"

FILES:${PN}-base += " \
			${sysconfdir}/samba/smb.conf \
			${sysconfdir}/samba/smb-secure.conf \
			${sysconfdir}/samba/shares/share.template \
			${sysconfdir}/init.d/samba.sh \
			${bindir}/testparm \
			${bindir}/smbpasswd \
			${bindir}/smbstatus \
			"

CONFFILES:${PN}-base += " \
						${sysconfdir}/samba/smb.user.conf \
						${sysconfdir}/samba/shares/share.template \
						"

# move smbpass config files to samba-common
FILES:${BPN}-common += " \
						${sysconfdir}/pam.d/samba \
						${sysconfdir}/samba/private/users.map \
						${sysconfdir}/samba/private/smbpasswd \
						"

CONFFILES:${BPN}-common += " \
						${sysconfdir}/pam.d/samba \
						${sysconfdir}/samba/private/users.map \
						${sysconfdir}/samba/private/smbpasswd \
						"

RPROVIDES:${PN} += "pam-pluginsmbpass"
RRECOMMENDS:${PN}-base += "wsdd pam-pluginsmbpass"

do_install:prepend() {
	install -d ${D}${sysconfdir}/sudoers.d
}

do_configure:prepend() {
	perl -i -pe 's#lp_private_dir#lp_pid_directory#' ${S}/source3/lib/messages.c
}

do_install:append() {
	rm -fR ${D}/var
	rm -fR ${D}/run
	rm -fR ${D}${sysconfdir}/tmpfiles.d
	rm -fR ${D}${sysconfdir}/sysconfig
	rm -f ${D}${sysconfdir}/init.d/samba
	install -d ${D}${sysconfdir}/pam.d
	install -m 644 ${UNPACKDIR}/pam.config ${D}${sysconfdir}/pam.d/samba
	install -d ${D}${sysconfdir}/samba
	install -m 644 ${UNPACKDIR}/smb.conf ${D}${sysconfdir}/samba
	install -m 644 ${UNPACKDIR}/smb-secure.conf ${D}${sysconfdir}/samba
	install -m 644 ${UNPACKDIR}/smb-user.conf ${D}${sysconfdir}/samba
	touch ${D}${sysconfdir}/samba/smb-shares.conf
	install -m 755 ${UNPACKDIR}/samba.sh ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/samba/shares
	install -m 644 ${UNPACKDIR}/share.template ${D}${sysconfdir}/samba/shares
	install -d ${D}${sysconfdir}/samba/private
	install -m 644 ${UNPACKDIR}/users.map ${D}${sysconfdir}/samba/private
	install -m 644 ${UNPACKDIR}/smbpasswd ${D}${sysconfdir}/samba/private
}

pkg_postinst:${PN}-common:prepend() {
#!/bin/sh

if [ -z "$D" ]; then
	# make sure we have the root user in smbpasswd
	[ -e /etc/samba/private/smbpasswd ] || touch /etc/samba/private/smbpasswd
	grep -qE '^root:' /etc/samba/private/smbpasswd
	if [[ $? -ne 0 ]] ; then
		smbpasswd -Lan root >/dev/null
	fi
fi

# add smbpass support to pam.d
grep -v "pam_smbpass.so" $D${sysconfdir}/pam.d/common-password > $D/var/tmp/common-password
printf "password\toptional\t\t\tpam_smbpass.so nullok use_authtok use_first_pass\n" >> $D/var/tmp/common-password
mv $D/var/tmp/common-password $D${sysconfdir}/pam.d/common-password
}

pkg_prerm:${BPN}-common() {
#!/bin/sh

# remove smbpass support from pam.d
grep -v "pam_smbpass.so" /etc/pam.d/common-password > /tmp/common-password
mv /tmp/common-password /etc/pam.d/common-password
}

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}-base"
INITSCRIPT_NAME:${PN}-base = "samba.sh"
INITSCRIPT_PARAMS:${PN}-base = "defaults"

# remove libnetapi package witch contains a lot of cross dependencies from libsamba-base
PACKAGES:remove = "libnetapi"

# move all libraries from samba to libsamba-base to fix circular dependencies
FILES:lib${PN}-base += "\
					${libdir}/*.so.* \
					${libdir}/samba/*.so \
					${libdir}/samba/*.so.* \
					"

# move some libraries from libsamba-base to libwbclient to fix circular dependencies
FILES:libwbclient = "${libdir}/libwbclient.so.* \
					${libdir}/samba/libwinbind-client.so \
					${libdir}/samba/libwinbind-client-samba4.so \
					${libdir}/samba/libreplace-samba4.so \
					"
