FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.3"
 
SRC_URI[sha256sum] = "47f78f500cbd900f758f9ba74288fda0e2ca5a7855096025641e121ffec40a5d"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
