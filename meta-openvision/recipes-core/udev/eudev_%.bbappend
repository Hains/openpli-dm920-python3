FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
	file://init \
	"

DEPENDS += " udev-extraconf"
RDEPENDS:${PN} += " udev-extraconf"
