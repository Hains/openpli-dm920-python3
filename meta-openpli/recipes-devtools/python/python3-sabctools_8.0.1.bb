SUMMARY = "C implementations of functions for use within SABnzbd"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI[md5sum] = "f03a4a9829a4823b91188bdb0ba7a856"
SRC_URI[sha256sum] = "f93412bf0a43668fc84dfade7a3a18aca5dcee630682fb043f2870666b07c95e"

SRC_URI:append = " file://remove-x64-flags.patch"

inherit pypi setuptools3

include python3-package-split.inc
