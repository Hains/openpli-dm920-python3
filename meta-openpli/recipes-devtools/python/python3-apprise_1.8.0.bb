SUMMARY = "Push Notifications that work with just about every platform!"
HOMEPAGE = "https://github.com/caronc/apprise"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b18f7da56457240ed21714dd6a74dd86"

DEPENDS = "python3-babel-native"

RDEPENDS:${PN} = "python3-pyyaml python3-markdown python3-click"

SRC_URI[md5sum] = "5ba5442a30bcbc8f8b86ce21060ad815"
SRC_URI[sha256sum] = "e8f58cebfea1a34f569cb4c68809a3175be80ec06f0a2ec473522b92023212c5"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
