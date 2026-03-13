SUMMARY = "Cheroot is the high-performance, pure-Python HTTP server used by CherryPy"
HOMEPAGE = "https://cheroot.cherrypy.org/"
SECTION = "devel/python"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=c4e17b64eab9c128f786f44f0dfb570a"
DEPENDS += "python3-setuptools-scm-native"

SRC_URI[md5sum] = "08ccbea749c4cd35b7371ced995d08b2"
SRC_URI[sha256sum] = "bfb70c49663f63b0440f2b54dbc6b0d1650e56dfe4e2641f59b2c6f727b44aca"

inherit pypi python_hatchling

include python3-package-split.inc
