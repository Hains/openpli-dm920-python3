DEFAULT_PREFERENCE = "1"

SUMMARY = "FUSE module for mounting an entire SMB/NMB network in a single directory"
DESCRIPTION = "SMBNetFS is a Linux/FreeBSD filesystem that allow you to use \
				samba/microsoft network in the same manner as the network \
				neighborhood in Microsoft Windows. Please donate me to help \
				in SMBNetFS development."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a"
HOMEPAGE ="http://sourceforge.net/projects/smbnetfs"

DEPENDS = "fuse samba"

inherit autotools gitpkgv pkgconfig

PKGV = "${GITPKGVTAG}"

SRCREV = "21c63ed60202e5540613d4c822a57a0b81764499"

SRC_URI = " git://git.code.sf.net/p/smbnetfs/git;branch=master \
			file://configure.patch \
			file://Using-PKG_CHECK_MODULES-to-found-headers-and-libraries.patch \
			file://smbnetfs.common.conf file://smbnetfs.user.conf file://init \
			"

PACKAGECONFIG = ""
PACKAGECONFIG[gnome-keyring] = "--with-gnome-keyring=yes,--with-gnome-keyring=no,libgnome-keyring"

S = "${WORKDIR}/git"

FILES_${PN} += "${sysconfdir}/*.conf ${sysconfdir}/init.d"
CONFFILES_${PN} = "${sysconfdir}/smbnetfs.user.conf"
inherit update-rc.d

INITSCRIPT_NAME = "${PN}.sh"

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 600 ${WORKDIR}/smbnetfs.common.conf ${D}${sysconfdir}/
	install -m 600 ${WORKDIR}/smbnetfs.user.conf ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/${PN}.sh
}
