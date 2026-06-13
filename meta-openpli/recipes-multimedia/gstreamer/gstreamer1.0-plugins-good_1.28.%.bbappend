FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.4"
 
SRC_URI[sha256sum] = "c825ea737c59cea0e4a0c41da2388045ff5dd32d162220ac93a7a82ee4a04e61"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
