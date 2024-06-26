FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.24.5"

SRC_URI[sha256sum] = "7fd16bdfa56ed51c40b474648fc35c4edde3e8ac934b12b82b49727b5d703521"

SRC_URI:append = " file://port-read-probe-to-ffinputformat.patch"

CFLAGS += "-Wno-error=incompatible-pointer-types"
