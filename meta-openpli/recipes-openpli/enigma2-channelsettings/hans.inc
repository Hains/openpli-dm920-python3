LICENSE = "LicenseRef-LICENSE-CLOSED"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/LICENSE-CLOSED;md5=2d5b03b35d4612637d67724b35738dd7"

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://gitlab.openpli.org/openpli/hanssettings.git;protocol=http;branch=master"

RDEPENDS:${PN} = "xz"

inherit gitpkgv allarch

FILES:${PN} = "/etc/enigma2/"

do_install () {
	install -d ${D}/etc/enigma2
	cp -r ${S}/${SETTINGS_FILENAME}/* ${D}/etc/enigma2
}
