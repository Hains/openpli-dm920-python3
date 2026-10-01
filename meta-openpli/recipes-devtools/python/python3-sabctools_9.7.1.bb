SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

DEPENDS = "python3-scikit-build-core-native ninja-native"

SRC_URI[md5sum] = "ff0808063921fbd180ef84ebe6d6fb32"
SRC_URI[sha256sum] = "6c0ada3fa74c894c5d656686bda18ac53d9926a84f2bf89e278828a46045cae4"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi python_hatchling

include python3-package-split.inc

INSANE_SKIP:${PN} += "already-stripped"
