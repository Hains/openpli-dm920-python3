FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.0"

SRC_URI[sha256sum] = "d97700f346fdf9ef5461c035e23ed1ce916ca7a31d6ddad987f774774361db77"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
