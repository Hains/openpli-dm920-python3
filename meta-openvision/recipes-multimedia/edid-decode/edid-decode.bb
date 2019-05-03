SUMMARY = "EDID decoder and conformance tester"
DESCRIPTION = "edid-decode decodes EDID monitor description data in human-readable format"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://edid-decode.c;beginline=1;endline=23;md5=09d30016632eac73aa7e8e58a367f6c1"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://linuxtv.org/edid-decode.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig
