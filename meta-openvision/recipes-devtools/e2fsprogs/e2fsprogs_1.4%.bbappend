FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "file://Revert-mke2fs-enable-the-metadata_csum.patch"
