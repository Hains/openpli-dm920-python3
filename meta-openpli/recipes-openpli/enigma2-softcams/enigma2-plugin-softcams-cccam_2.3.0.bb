DESCRIPTION = "CCcam ${PV} softcam"

CCCAMVER = "230"
CAMNAME = "CCcam${CCCAMVER}"

RDEPENDS_${PN} = "libxcrypt"

SRC_URI = " http://downloads.openpli.org/softcams/CCcam-${PV}.zip;name=softcam \
			http://downloads.openpli.org/softcams/CCcam.xml;name=ppanel \
			"

S = "${WORKDIR}"

require softcam.inc

INHIBIT_PACKAGE_STRIP = "1"

CONFFILES = "/etc/CCcam.cfg /etc/ppanels/CCcam.xml"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/CCcam.${TARGET_ARCH} ${D}/usr/bin/${CAMNAME}
	install -d ${D}/etc
	install -m 0644 ${S}/CCcam.cfg ${D}/etc/CCcam.cfg
	install -d ${D}/etc/ppanels
	install -m 0644 ${WORKDIR}/CCcam.xml ${D}/etc/ppanels/CCcam.xml
}

SRC_URI[softcam.md5sum] = "2f76eacbd286255a505dbc983df9cb6c"
SRC_URI[softcam.sha256sum] = "3c46de7a17357ebcde8ff31276ede67d0e05358b2eaf3b206d3e0242176f1de6"
SRC_URI[ppanel.md5sum] = "6d9c1964e0f65278b8f3024772b69d13"
SRC_URI[ppanel.sha256sum] = "bd4e0b2b088a4a977d431ae1bb85fae142020f7b6f88baba06f9757f1b1cd9e2"
