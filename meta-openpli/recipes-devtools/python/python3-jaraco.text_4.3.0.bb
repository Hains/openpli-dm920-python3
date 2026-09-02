SUMMARY = "Module for text manipulation"
HOMEPAGE = "https://github.com/jaraco/jaraco.text"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2e21c3f75eb8d9427c8a611a8e83e9d6"
DEPENDS += "python3-setuptools-scm-native python3-coherent-licensed-native"

PYPI_PACKAGE = "jaraco_text"

SRC_URI[md5sum] = "23d91c6899e89f3bb1bb6f9148302b92"
SRC_URI[sha256sum] = "ddd5eb6259d0701e08cb642c8d6b63bcc73947d03df9239ea67bbef911b3e4e1"

inherit pypi python_setuptools_build_meta
