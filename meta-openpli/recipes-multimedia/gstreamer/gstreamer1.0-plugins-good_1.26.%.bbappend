FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.2"

SRC_URI[sha256sum] = "1ace2d8ec74f632d82eab5006753a27fe0c2402db4ca94d63271e494b62f50bf"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
