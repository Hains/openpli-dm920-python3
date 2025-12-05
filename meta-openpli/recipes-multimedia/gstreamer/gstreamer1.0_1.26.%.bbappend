FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.9"

SRC_URI[sha256sum] = "8ee8772e468102ebe86d414d8c4c7440dd91d9f3e9396952ff23aecde80670c8"

SRC_URI:append = " file://001-revert-use-new-gst-adapter-get-buffer.patch"
