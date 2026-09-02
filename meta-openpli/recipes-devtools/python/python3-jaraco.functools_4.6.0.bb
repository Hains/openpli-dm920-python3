SUMMARY = "Functools like those found in stdlib"
HOMEPAGE = "https://github.com/jaraco/jaraco.functools"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2e21c3f75eb8d9427c8a611a8e83e9d6"

DEPENDS += "python3-setuptools-scm-native python3-coherent-licensed-native"

PYPI_PACKAGE = "jaraco_functools"

SRC_URI[md5sum] = "24f0dae58bf6fadad9340a29e2353b56"
SRC_URI[sha256sum] = "880c577ec9720b3a052d5bc611fb9f2269b3d87902ef42440df443b88e443280"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
