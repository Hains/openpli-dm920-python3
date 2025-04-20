MODULE = "FileCommander"
DESCRIPTION = "File manager based on OpenATV one"

inherit setuptools3-openplugins

require openplugins.inc

SRC_URI:append = " file://use-setuptools-instead-of-distutils.patch \
                   file://set-list-before-update.patch \
                   file://use-python3-name.patch \
"
