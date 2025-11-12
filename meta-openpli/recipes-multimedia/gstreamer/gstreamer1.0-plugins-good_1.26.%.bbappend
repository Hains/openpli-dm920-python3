FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.8"

SRC_URI[sha256sum] = "061e84efae31dfb4d96e4517659aca82bad9d5625b8f64d3290604385edd1d14"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
