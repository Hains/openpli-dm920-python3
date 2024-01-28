MODULE = "AutoBackup"
SUMMARY = "Backup settings and restore them automatically"
DESCRIPTION = "Can create daily backups. Backups created will be restored automaticaly after a new flash."

inherit setuptools3-openplugins

require openplugins.inc

# I spent over 2 hours trying to get the shell file to be executable. Sorry, I just gave up
# and decided that this would be good enough until someone explains how to do this properly
# with distutils.
do_install:append() {
	chmod a+x ${D}${libdir}/enigma2/python/Plugins/*/*/*.sh
}

DEPENDS = "python3-future-native"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-AutoBackup.git;branch=python3;protocol=https file://use-setuptools-instead-of-distutils.patch"
