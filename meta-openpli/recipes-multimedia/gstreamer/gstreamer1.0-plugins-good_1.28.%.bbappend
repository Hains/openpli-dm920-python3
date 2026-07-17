FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.5"

SRC_URI[sha256sum] = "58b45d24a1d77b39d7bb7d9ccc6e2d76bbf28618998c335c163f18e6f94a9324"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
