FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "3.12.2"
PKGV = "3.12.2"

SRC_URI[sha256sum] = "be28112dac813d2053545c14bf13a16401a21877f1a69eb6ea5d84c4a0f3d870"

SRC_URI:append = " file://suppress-error-parsetuple-with-hashtag.patch"
