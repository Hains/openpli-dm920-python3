SUMMARY = "A pure Python DAAP client implementation"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fbc093901857fcd118f065f900982c24"
PR = "r2"

inherit setuptools3

SRCREV = "fe13e119841550f5ac0c87a1f81b07021d4a78d3"

SRC_URI = "git://github.com/abdelgmartinezl/PythonDaap;protocol=https;branch=master \
           file://python-daap.patch \
           file://The-member-ob_type-is-not-present-in-the-pcapobject.patch \
           file://use-setuptools-instead-of-distutils.patch \
           file://fix-build-with-gcc15.patch \
"

RDEPENDS:${PN} = "python3-compression"

SRC_URI[md5sum] = "b3db3d60b0ee83f5f23101d2c3bb99e0"
SRC_URI[sha256sum] = "ea1d3a8141654781a0df31e6607c4722436fa33eb2e9934492770b3b61be8122"

include python3-package-split.inc

CFLAGS += "-Wno-error=int-conversion -Wno-error=implicit-function-declaration -Wno-error=incompatible-pointer-types"
