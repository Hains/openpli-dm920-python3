FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "1.28.5"

SRC_URI[sha256sum] = "a5a9f783809b17a8eb774f4a7695b2cb8cba6b15520129906f87eaf30e7f8469"

SRC_URI:append = " file://001-revert-use-new-gst-adapter-get-buffer.patch"
