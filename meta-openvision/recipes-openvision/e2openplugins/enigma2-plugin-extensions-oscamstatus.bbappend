FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://fix-autodetection.patch \
			file://remove-duplicate-server-name.patch \
"
