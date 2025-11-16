DESCRIPTION = "PlutoTV plugin for enigma2"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://src/LICENSE;md5=c644709e9dad24bd9bf90ac96687ed2f"

RREPLACES:${PN} = "enigma2-plugin-extensions-pluto"

RDEPENDS:${PN} = "python3-requests"

inherit gitpkgv allarch gettext setuptools3-openplugins python3-compileall

PV = "1.1+git"
PKGV = "1.1+git${GITPKGV}"

SRC_URI = "git://github.com/OpenViX/PlutoTV.git;protocol=https;branch=master"
