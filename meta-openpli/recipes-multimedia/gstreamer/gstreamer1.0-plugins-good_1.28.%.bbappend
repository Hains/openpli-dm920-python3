FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.7"

SRC_URI[sha256sum] = "87256969c82cf3bc8574301f3e7044a90de0ac500a5a27d8ba38c4dde894dd8b"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
