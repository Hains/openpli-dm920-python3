MAINTAINER = "team@sabnzbd.org"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=11d738004e69db5356c633936aa54836"

PR = "r1"

DEPENDS = "python"
RDEPENDS_${PN} = "\
	python-core python-shell python-compression python-crypt python-ctypes python-sqlite3 \
	python-cheetah python-misc python-subprocess python-html python-email python-yenc \
	"
RRECOMMENDS_${PN} = "par2cmdline unrar"

SRC_URI = "https://github.com/sabnzbd/sabnzbd/archive/2.3.1.tar.gz \
	file://sabnzbd.ini \
	"

SRC_URI[md5sum] = "ad99fe61475b5579f36fc147e7312611"
SRC_URI[sha256sum] = "0214f8497c3422649274128dfec10090c44e8bf1911aed14cb44d877424b45ef"

S = "${WORKDIR}/sabnzbd-${PV}"

INSTALLDIR = "/usr/lib/${PN}"

PACKAGES = "${PN}-doc ${PN}-src ${PN}"

FILES_${PN}-src = "${INSTALLDIR}/*/*.py ${INSTALLDIR}/*/*/*.py"
FILES_${PN}-doc = "${INSTALLDIR}/*.txt ${INSTALLDIR}/licenses ${INSTALLDIR}/interfaces/*/licenses"
FILES_${PN} = "${INSTALLDIR} /etc/init.d /etc/init.d/sabnzbd /etc/sabnzbd.ini"

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
	install -m 644 ${WORKDIR}/sabnzbd.ini ${D}/etc/sabnzbd.ini
}
