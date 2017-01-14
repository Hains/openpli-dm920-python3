SUMMARY = "DVD access multimeda library"
SECTION = "libs/multimedia"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=64e753fa7d1ca31632bc383da3b57c27"
PV = "5.0.4"
PR = "r0"

inherit autotools pkgconfig git-project

SRCREV = "5ec409508803037dfa931591aef93851458d1d2a"
SRC_URI = "git://github.com/mirror/libdvdread"

