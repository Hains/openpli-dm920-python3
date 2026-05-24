FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://fix-build.patch;patchdir=../curl-sys-0.4.83+curl-8.15.0/"
