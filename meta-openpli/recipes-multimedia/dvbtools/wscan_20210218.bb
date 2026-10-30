SUMMARY = "Small command line utility used to perform frequency scans for DVB and ATSC transmissions"
DESCRIPTION = "Wscan is a dvb channel scanner that doesn't require an initial frequency table"
HOMEPAGE = "http://wirbel.htpc-forum.de/w_scan/index2.html"
MAINTAINER = "wirbel <w_scan@gmx-topmail.de>"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "file://w_scan-20210218.tar.bz2 \
           file://fix-build-with-gcc15.patch \
"

SRC_URI[md5sum] = "2b1e617652768462256b635997ecd07e"
SRC_URI[sha256sum] = "97061b92e1d287d3a23769b1f1dd2691985f9bf66a3d47f5eb900d3ed78e7838"

S = "${UNPACKDIR}/w_scan-${PV}"

inherit autotools

FILES:${PN} += "${datadir}"
