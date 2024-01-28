MODULE = "PPanel"
DESCRIPTION = "PPanel"

inherit setuptools3-openplugins

require openplugins.inc

PACKAGES =+ "${PN}-example"

FILES:${PN} = "${prefix}"
FILES:${PN}-example = "/etc/ppanel/PPanel_tutorial.xml"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-PPanel.git;branch=python3;protocol=https \
           file://use-setuptools-instead-of-distutils.patch \
"
