FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.7"

SRC_URI[sha256sum] = "18a5e214114dc501407697dd458514bba62cadd5414c60f793cf70141a4d0bb3"

SRC_URI:append = " file://001-revert-use-new-gst-adapter-get-buffer.patch"
