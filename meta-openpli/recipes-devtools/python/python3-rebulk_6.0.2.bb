SUMMARY  = "Rebulk - Define simple search patterns in bulk to perform advanced matching on any string."
HOMEPAGE = "https://github.com/Toilal/rebulk/"
SECTION = "devel/python"
LICENSE = "BSD-4-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=df5f9321c8784271adb6c95a3da69f82"

DEPENDS = "python3-uv-build-native"
RDEPENDS:${PN} = "python3-regex"

SRC_URI[md5sum] = "c44b3e98f2bdebe4ab20ecb6466c7787"
SRC_URI[sha256sum] = "91d792483690aeb249bb56b3357598dd658f0f533066680db8c3e1b6f7dc8929"

SRC_URI:append = " file://increase-max-version-uv-build.patch"

inherit pypi python_hatchling

include python3-package-split.inc
