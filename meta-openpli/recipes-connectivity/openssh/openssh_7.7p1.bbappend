SRC_URI += "file://fix-build-openssl110.patch"

DEPENDS = "zlib openssl"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
