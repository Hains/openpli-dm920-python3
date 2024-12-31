SUMMARY = "SABnzbd - The automated Usenet download tool"
DESCRIPTION = "SABnzbd is an Open Source Binary Newsreader written in Python."
HOMEPAGE = "https://sabnzbd.org"
MAINTAINER = "team@sabnzbd.org"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=dc94785ad7ae0960293331f807d14628"

RDEPENDS:${PN} = "\
	python3-core python3-shell python3-compression python3-crypt python3-ctypes python3-sqlite3 \
	python3-cheetah python3-misc python3-html python3-email python3-sabyenc3 python3-sabctools \
	python3-rebulk python3-dateutil python3-babelfish python3-pysocks python3-pip p7zip python3-apprise \
	"

RRECOMMENDS:${PN} = "par2cmdline unrar"

SRC_URI = "https://github.com/sabnzbd/sabnzbd/releases/download/${PV}/SABnzbd-${PV}-src.tar.gz \
	file://sabnzbd \
	file://sabnzbd.conf \
	file://init-functions \
	"

SRC_URI[md5sum] = "4e607b5a187d6081037e71cc1cafef34"
SRC_URI[sha256sum] = "a9ebf273d77c6d3cc9a13b1bd1640b903f4891e58aee3ef5a25595db3aa4d7fb"

S = "${WORKDIR}/SABnzbd-${PV}"

INSTALLDIR = "${libdir}/${PN}"

PACKAGES = "${PN}-doc ${PN}-src ${PN}"

FILES:${PN}-src = "${INSTALLDIR}/*.py ${INSTALLDIR}/*/*.py ${INSTALLDIR}/*/*/*.py"
FILES:${PN}-doc = "${INSTALLDIR}/*.txt ${INSTALLDIR}/licenses ${INSTALLDIR}/interfaces/*/licenses"
FILES:${PN} = "${INSTALLDIR} /etc/init.d/sabnzbd /etc/init.d/init-functions /etc/enigma2/sabnzbd.conf"

inherit update-rc.d python3-compileall
INITSCRIPT_NAME = "sabnzbd"
INITSCRIPT_PARAMS = "defaults"

do_install() {
	install -d ${D}${INSTALLDIR}
	cp -r . ${D}${INSTALLDIR}/
	rm -rf ${D}${INSTALLDIR}/.git
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${UNPACKDIR}/sabnzbd ${D}${sysconfdir}/init.d/sabnzbd
	install -m 755 ${UNPACKDIR}/init-functions ${D}${sysconfdir}/init.d/init-functions
	install -d ${D}${sysconfdir}/enigma2
	install -m 644 ${UNPACKDIR}/sabnzbd.conf ${D}/etc/enigma2/sabnzbd.conf
}

do_install:append() {
	chmod 777 ${D}${INSTALLDIR}/SABnzbd.py
}
