FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "3.13.8"

SRC_URI[sha256sum] = "b9910730526b298299b46b35595ced9055722df60c06ad6301f6a4e2c728a252"

SRC_URI:remove = "file://0001-gh-90548-Skip-NODEV-portion-of-test_makedev-when-lin.patch"
