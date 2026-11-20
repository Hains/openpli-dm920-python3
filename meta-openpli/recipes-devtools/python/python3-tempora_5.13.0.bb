SUMMARY = "Objects and routines pertaining to date and time (tempora)"
HOMEPAGE = "https://github.com/jaraco/tempora"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://README.md;md5=ad43b1982ca4f2a78918f53c01593aa3"
DEPENDS += "python3-setuptools-scm-native"

SRC_URI[md5sum] = "644e520d3c9619dc9770f1c8448aa4b3"
SRC_URI[sha256sum] = "1e6fe03d8c9ccec557e58f18bf3743e6c1a7b09b32bcda07b73be233ef5b24c1"

inherit pypi python_hatchling

include python3-package-split.inc
