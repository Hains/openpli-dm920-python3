MODULE = "SystemTools"
DESCRIPTION = "System Tools for enigma2 stb"

inherit setuptools3-openplugins

require openplugins.inc

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch"
