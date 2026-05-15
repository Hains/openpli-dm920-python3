FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.3"
 
SRC_URI[sha256sum] = "5e84ecb942e136944eb9812f19cff7bcf05a85637482a32da55b892914c397d1"

SRC_URI:append = " file://001-revert-use-new-gst-adapter-get-buffer.patch"
