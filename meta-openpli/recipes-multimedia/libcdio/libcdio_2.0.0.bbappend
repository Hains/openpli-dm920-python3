FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI +=  "file://0001-Fix-small-I-O-leak-when-we-can-t-read-ISO-file.patch \
			"
