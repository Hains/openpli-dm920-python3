FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "bc6b94b015fdaf7c4dab56ccb996eecea8bc4373"

SRC_URI = " git://smbnetfs.git.sourceforge.net/gitroot/smbnetfs/smbnetfs;branch=master \
			file://configure.patch \
			file://Using-PKG_CHECK_MODULES-to-found-headers-and-libraries.patch \
			file://smbnetfs.common.conf \
			file://smbnetfs.user.conf \
			file://init \
			"

PACKAGECONFIG[gnome-keyring] = ""
PACKAGECONFIG[libsecret] = "--with-libsecret=yes,--with-libsecret=no,libsecret"

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
