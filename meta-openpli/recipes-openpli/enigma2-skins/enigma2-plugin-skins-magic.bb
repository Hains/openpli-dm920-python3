DESCRIPTION = "Magic skin for Enigma2"
MAINTAINER = "Mike Looijmans"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb723b61539feef013de476e68b5c50a"

inherit gitpkgv allarch

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

PKGV:font-valis-enigma = "1.0+git${GITPKGV}"
DESCRIPTION:font-valis-enigma = "Valis enigma font"

PACKAGES = "${PN} font-valis-enigma"
PROVIDES += "font-valis-enigma"

GITHUB_URI ?= "git://github.com"
SRC_URI = "${GITHUB_URI}/OpenPLi/${BPN}.git;protocol=https;branch=master"

FILES:${PN} = "${datadir}/enigma2/Magic"
FILES:font-valis-enigma = "${datadir}/fonts/valis_enigma.ttf"

RDEPENDS:${PN} = "font-valis-enigma"

do_install() {
	install -d ${D}${datadir}
	cp -r --preserve=mode,links ${S}${datadir}/* ${D}${datadir}/
	chmod -R a+rX ${D}${datadir}/enigma2/
	chmod 644 ${D}${datadir}/fonts/*.ttf
}
