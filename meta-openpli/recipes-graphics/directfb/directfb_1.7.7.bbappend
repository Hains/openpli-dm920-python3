BBCLASSEXTEND = "native"

SRC_URI += "file://fix-build.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
