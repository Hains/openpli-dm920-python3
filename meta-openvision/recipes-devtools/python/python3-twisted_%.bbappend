FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://use-decodebytes.patch"

FILES_${PN}-src = ""
