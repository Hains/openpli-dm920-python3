FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://suppress-error-parsetuple-with-hashtag.patch"
