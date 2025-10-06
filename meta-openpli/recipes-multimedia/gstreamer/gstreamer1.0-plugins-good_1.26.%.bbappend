FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.6"

SRC_URI[sha256sum] = "d0956535c8315856df9ca2de495f7725128b462863b3c7cd357ef64fb4199679"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
