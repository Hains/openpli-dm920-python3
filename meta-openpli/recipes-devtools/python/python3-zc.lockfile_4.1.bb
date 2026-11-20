SUMMARY = "Basic inter-process locks"
HOMEPAGE = "https://github.com/zopefoundation/zc.lockfile"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=78ccb3640dc841e1baecb3e27a6966b2"

DEPENDS += "python3-setuptools-scm-native python3-wheel-native"

SRC_URI:append = " file://bump-max-version-setuptools.patch"

SRC_URI[md5sum] = "86e63cc351f60e0d1b14cf2e226950dc"
SRC_URI[sha256sum] = "498f37d33a36d1b1534ea31a0fbe3b5d371c862baeb8805f467a6d39948011ef"

inherit pypi python_hatchling

include python3-package-split.inc
