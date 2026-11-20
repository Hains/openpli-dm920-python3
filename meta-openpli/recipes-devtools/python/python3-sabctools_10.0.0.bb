SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

DEPENDS = "python3-scikit-build-core-native ninja-native"

SRC_URI[md5sum] = "cbeba7d9eb3a40b014a55feb4cd0c81f"
SRC_URI[sha256sum] = "b93940bc63b8af55dc9973a7e2cf3075dcb80da103a95339d270e1211376ada3"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi python_hatchling

include python3-package-split.inc

INSANE_SKIP:${PN} += "already-stripped"
