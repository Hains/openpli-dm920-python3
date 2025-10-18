FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "3.13.9"

SRC_URI[sha256sum] = "ed5ef34cda36cfa2f3a340f07cac7e7814f91c7f3c411f6d3562323a866c5c66"

SRC_URI:remove = "file://0001-gh-90548-Skip-NODEV-portion-of-test_makedev-when-lin.patch"
