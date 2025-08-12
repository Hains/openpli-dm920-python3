FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.26.5"

SRC_URI[sha256sum] = "0a7edb0e7b42dbe6b575fce61a4808a3f6b20e085a1eaecbc025d0ec21f1e774"

SRC_URI:append = " file://001-revert-use-new-gst-adapter-get-buffer.patch"
