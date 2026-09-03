UMMARY = "Python Levenshtein"
HOMEPAGE = "http://github.com/joncasdam/python-Levenshtein"
SECTION = "devel/python"
DEPENDS = "python3"
LICENSE = "LGPL-2.0-or-later"
LIC_FILES_CHKSUM = " file://LICENSE;md5=37addc8bb77be42f2f0a1a68b235556f"

DEPENDS = "ninja-native cmake-native python3-scikit-build-core-native"

PYPI_PACKAGE = "levenshtein"

SRC_URI[md5sum] = "2a7a6257cdacb26e36e86a31eeecfe7a"
SRC_URI[sha256sum] = "3df1c12bf5e485774d6387f3894271ef3724414ecc20dd238ae4d2333e093c83"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc

INSANE_SKIP:${PN} += "already-stripped"
