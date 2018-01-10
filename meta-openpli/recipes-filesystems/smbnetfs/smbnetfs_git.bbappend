FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "bc6b94b015fdaf7c4dab56ccb996eecea8bc4373"

SRC_URI = " git://smbnetfs.git.sourceforge.net/gitroot/smbnetfs/smbnetfs;branch=master \
			file://configure.patch \
			file://Using-PKG_CHECK_MODULES-to-found-headers-and-libraries.patch \
			"

PACKAGECONFIG[gnome-keyring] = ""
PACKAGECONFIG[libsecret] = "--with-libsecret=yes,--with-libsecret=no,libsecret"
