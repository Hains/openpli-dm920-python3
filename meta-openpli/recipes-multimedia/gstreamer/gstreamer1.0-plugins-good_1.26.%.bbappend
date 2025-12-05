FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.9"

SRC_URI[sha256sum] = "f38566fb53ae56b7019a039475311756a28eb978a781154d67813dcb551ff5fe"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
