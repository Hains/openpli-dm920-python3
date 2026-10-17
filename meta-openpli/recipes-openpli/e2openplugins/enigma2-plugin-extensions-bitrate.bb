MODULE = "Bitrate"
DESCRIPTION = "Bitrate viewer"

require openplugins.inc

inherit autotools gettext python3native

DEPENDS += "python3"

SRC_URI:append = " file://drop-python3-six.patch"

EXTRA_OECONF = " \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR}"

FILES:${PN} = "${libdir} ${bindir}"
