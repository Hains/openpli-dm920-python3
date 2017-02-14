SRCREV = "ed8d5ffd0a14e84298a15ae2ec9b799010166b28"

SRC_URI_append += " file://030-revert-getentropy.patch \
			"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
