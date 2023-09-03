SUMMARY = "Dreambox TS/M2TS audio passthrough helper lib"
DEPENDS = "libdlsym openssl"

SRC_URI = "file://libpassthrough_0.6_cortexa15hf-neon-vfpv4.tar.xz"

SRC_URI[cortexa15hf-neon-vfpv4.md5sum] = "2760da32a2553c88f6782525bb986495"
SRC_URI[cortexa15hf-neon-vfpv4.sha256sum] = "498c3412025350da77f67bd56bcc32a60c5692a164b8605f090029029ea1a2b7"

inherit opendreambox-precompiled-binary

FILES:${PN} = "${libdir}/lib*${SOLIBSDEV}"
FILES_SOLIBSDEV = ""

DEBIAN_NOAUTONAME:${PN} = "1"
