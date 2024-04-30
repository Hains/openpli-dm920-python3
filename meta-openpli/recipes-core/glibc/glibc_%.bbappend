FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0006-PATCH-remove-arc4random-implementation.patch"
