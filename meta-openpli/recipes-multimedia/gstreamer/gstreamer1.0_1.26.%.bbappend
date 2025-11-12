FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.8"

SRC_URI[sha256sum] = "2348e837464c3cb7423b79fc1cc8c4c994c74603443bd97d14edc6cd5ca7db13"

SRC_URI:append = " file://001-revert-use-new-gst-adapter-get-buffer.patch"
