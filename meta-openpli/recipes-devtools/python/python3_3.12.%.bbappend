FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "3.12.4"

SRC_URI[sha256sum] = "f6d419a6d8743ab26700801b4908d26d97e8b986e14f95de31b32de2b0e79554"

SRC_URI:append = " file://suppress-error-parsetuple-with-hashtag.patch"
