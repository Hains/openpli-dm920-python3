DESCRIPTION = "PLi HD skin"
MAINTAINER = "littlesat"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://usr/share/enigma2/PLi-HD/skin.xml;beginline=3;endline=8;md5=1d560d35b9194281a488eb3a32d9c8bf"

inherit gitpkgv allarch

PV = "0.1+git"
PKGV = "0.1+git${GITPKGV}"

SRC_URI = "git://github.com/littlesat/skin-PLiHD.git;branch=master;protocol=https \
           file://restore-rainbow-bar.patch \
           file://revert-PLiFullHD-darker.patch \
           file://bar_snr.png \
           file://bar_agc.png \
"

FILES:${PN} = "${datadir}/enigma2/"

do_compile() {
}

do_install:append() {
	cp ${UNPACKDIR}/bar_snr.png ${D}${datadir}/enigma2//PLi-FullHD/icons/
	cp ${UNPACKDIR}/bar_agc.png ${D}${datadir}/enigma2//PLi-FullHD/icons/
}

do_install() {
	install -d ${D}${datadir}
	cp -r ${S}${datadir}/* ${D}${datadir}/
	chmod -R a+rX ${D}${datadir}/enigma2/
}
