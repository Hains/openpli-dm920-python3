SUMMARY  = "UDF reader"
SECTION = "misc"
HOMEPAGE = "http://videolan.org"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://code.videolan.org/videolan/libudfread.git;branch=master;protocol=http"

inherit gitpkgv autotools-brokensep pkgconfig

PV = "1.0.0+git"
PKGV = "1.0.0+git${GITPKGV}"
