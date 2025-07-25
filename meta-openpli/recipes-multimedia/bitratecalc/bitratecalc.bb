DESCRIPTION = "Library that implements bitrate calculations from enigma2"
LICENSE = "CC-BY-NC-ND-4.0"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "enigma2"

inherit autotools gitpkgv pkgconfig python3native python3targetconfig

SRCREV = "${AUTOREV}"
PV = "git"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/fairbird/bitratecalc.git;protocol=https;branch=master"

FILES:${PN} = "${libdir}/bitratecalc.so"
