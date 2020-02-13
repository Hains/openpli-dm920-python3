FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
			file://fix-writing-after-channel-is-closed.patch \
			file://twisted-17.9.0-python-27-utf-8-fix.patch \
			"

FILES_${PN}-src = ""
