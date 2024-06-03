FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch"
SRC_URI:remove = "file://0001-v4l2-Define-ioctl_req_t-for-posix-linux-case.patch"

PACKAGECONFIG:append = " amrnb amrwb vpx wavpack"
