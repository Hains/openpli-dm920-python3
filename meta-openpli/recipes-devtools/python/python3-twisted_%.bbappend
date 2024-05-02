FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RDEPENDS:${PN}-newsfragements = "${PN}-core"

SRC_URI:append = " file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch"

inherit python_setuptools_build_meta

PACKAGES += "${PN}-newsfragments"

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/${PYPI_PACKAGE}-${PV}.dist-info/*"

FILES:${PN}-newsfragments = " \
    ${PYTHON_SITEPACKAGES_DIR}/twisted/newsfragments \
"
