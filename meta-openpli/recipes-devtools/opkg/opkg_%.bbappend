FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://opkg.conf \
			file://modprobe \
			"

PACKAGECONFIG:remove = "sha256"

do_install:prepend() {
	install -d ${D}${datadir}/opkg/intercept
	install -m 755 ${UNPACKDIR}/modprobe ${D}${datadir}/opkg/intercept/
}
