FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://0001-vendor-Add-openssl-sys-0.9.114.patch;patchdir=${RUSTSRC} \
                   file://fix-build.patch;patchdir=${RUSTSRC} \
                   "
