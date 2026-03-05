FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.1"

SRC_URI[sha256sum] = "738e26aee41b7a62050e40b81adc017a110a7f32d1ec49fa6a0300846c44368d"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
