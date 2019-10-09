DESCRIPTION = "CCcam ${PV} softcam"

CAMNAME = "CCcam"

RDEPENDS_${PN} = "libxcrypt-compat"

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

SRC_URI[softcam.md5sum] = "042bc8d82075dbc806787270ffa237f6"
SRC_URI[softcam.sha256sum] = "2b589e8181b927c0c0a7b0a045c500b1270234f8fab0848ba05201e339df2b51"
SRC_URI[ppanel.md5sum] = "6d9c1964e0f65278b8f3024772b69d13"
SRC_URI[ppanel.sha256sum] = "bd4e0b2b088a4a977d431ae1bb85fae142020f7b6f88baba06f9757f1b1cd9e2"
