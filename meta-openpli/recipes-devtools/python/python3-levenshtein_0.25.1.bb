UMMARY = "Python Levenshtein"
HOMEPAGE = "http://github.com/joncasdam/python-Levenshtein"
SECTION = "devel/python"
DEPENDS = "python3"
LICENSE = "LGPL-2.0-or-later"
LIC_FILES_CHKSUM = " file://COPYING;md5=e4dc568e8869637acb7c89f0889d8130"

inherit python3native

DEPENDS = "python3-scikit-build-native"

PYPI_PACKAGE = "Levenshtein"

SRC_URI[md5sum] = "e65a7401be8e8eaa2c61b5ccb8e57d15"
SRC_URI[sha256sum] = "2df14471c778c75ffbd59cb64bbecfd4b0ef320ef9f80e4804764be7d5678980"

SRC_URI:append = " file://add-exception-argument.patch"

S = "${WORKDIR}/python-Levenshtein-${PV}"

inherit pypi setuptools3

include python3-package-split.inc
