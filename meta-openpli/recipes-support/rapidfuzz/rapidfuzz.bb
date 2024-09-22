DESCRIPTION = "RapidFuzz provides libraries for fuzzy string matching in various programming languages."
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://${S}/README.md;md5=cd30fe688968c142c6223b363c0bcd3b"

DEPENDS += "scikit-build-core-native ninja-native cmake-native python3-cython-native"

SRC_URI="git://github.com/rapidfuzz/rapidfuzz;branch=main;protocol=https \
         file://remove-cmake-check.patch \
         "

S = "${WORKDIR}/git"

inherit pkgconfig python_flit_core

SRCREV = "${AUTOREV}"

PV = "3.9.7.+git${SRCPV}"
PKGV = "3.9.7+git${GITPKGV}"
