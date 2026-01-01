FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.10"

SRC_URI[sha256sum] = "d7f20bec75edeb8677662926c33e987da64a42616c24fc3353b9ad44ed750cd6"

SRC_URI:append = " file://001-revert-use-new-gst-adapter-get-buffer.patch"
