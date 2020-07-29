MODULE = "Foreca"
DESCRIPTION = "Weather forecast for the upcoming 10 days"
RDEPENDS_${PN} = "python3-html"

inherit gitpkgv
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r0"

require conf/license/license-gplv2.inc
require openplugins-distutils.inc

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-Foreca.git;branch=python3"

FILES_${PN} += "${sysconfdir}/enigma2/Foreca"
CONFFILES_${PN} = "${sysconfdir}/enigma2/Foreca/City.cfg ${sysconfdir}/enigma2/Foreca/Filter.cfg"
