FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.6"

SRC_URI[sha256sum] = "b0c620a4b18b6ee931b4c43bbf1760d308666dc37f730a7e7f1ad327e59ce2df"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
