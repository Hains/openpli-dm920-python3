MAINTAINER = "team@sabnzbd.org"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=7c333056bf8b3834c43ccf2505d10690"

PR = "r1"

DEPENDS = "python"
RDEPENDS_${PN} = "\
	python-core python-shell python-compression python-crypt python-ctypes python-sqlite3 \
	python-cheetah python-misc python-subprocess python-html python-email python-yenc \
	"
RRECOMMENDS_${PN} = "par2cmdline unrar"

SRC_URI = "https://sourceforge.net/projects/sabnzbdplus/files/latest/download/sabnzbd-${PV}.tar.gz \
	file://sabnzbd \
	file://sabnzbd.ini"

SRC_URI[md5sum] = "c3b104572ddaa94ca136a1c9d1d6d4d9"
SRC_URI[sha256sum] = "5a27048877d78f87f03e5f9fc7d74dca12fe86958b935dc585f9f534071ebf36"

S = "${WORKDIR}/SABnzbd-${PV}"

INSTALLDIR = "/usr/lib/${PN}"

PACKAGES = "${PN}-doc ${PN}-src ${PN}"

FILES_${PN}-src = "${INSTALLDIR}/*/*.py ${INSTALLDIR}/*/*/*.py"
FILES_${PN}-doc = "${INSTALLDIR}/*.txt ${INSTALLDIR}/licenses ${INSTALLDIR}/interfaces/*/licenses"
FILES_${PN} = "${INSTALLDIR} /etc/init.d/sabnzbd /etc/sabnzbd.ini"

inherit update-rc.d
INITSCRIPT_NAME = "sabnzbd"
INITSCRIPT_PARAMS = "defaults"

do_compile() {
	python -O -m compileall .
}

do_install() {
	install -d ${D}${INSTALLDIR}
	cp -r . ${D}${INSTALLDIR}/
	install -d ${D}/etc/init.d
	install -m 755 ${WORKDIR}/sabnzbd ${D}/etc/init.d/sabnzbd
	install -m 644 ${WORKDIR}/sabnzbd.ini ${D}/etc/sabnzbd.ini
}
