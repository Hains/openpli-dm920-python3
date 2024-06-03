FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://port-read-probe-to-ffinputformat.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"
