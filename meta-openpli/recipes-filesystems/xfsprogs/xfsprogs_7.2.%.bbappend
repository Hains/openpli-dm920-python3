FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://use-64-bit-integer-as-datatype.patch"
