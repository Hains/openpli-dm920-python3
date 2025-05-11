FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.1"

SRC_URI[sha256sum] = "fcdcb2f77620a599557b2843d1c6c55c2b660f5fc28222b542847d11d9ca982f"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
