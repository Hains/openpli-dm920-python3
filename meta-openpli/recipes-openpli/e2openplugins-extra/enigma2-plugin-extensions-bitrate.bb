MODULE = "Bitrate"
DESCRIPTION = "Bitrate viewer"

require ../e2openplugins/openplugins-replace-pli.inc

PR="r1"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-${MODULE}.git;protocol=git"

S="${WORKDIR}/git"

SRCREV = "${AUTOREV}"

inherit setuptools autotools

EXTRA_OECONF = "STAGING_INCDIR=${STAGING_INCDIR} \
				STAGING_LIBDIR=${STAGING_LIBDIR}"

FILES_${PN} = "${libdir} ${bindir}"

require assume-gplv2.inc
