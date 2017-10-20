SUMMARY = "Incremental is a small library that versions your Python projects."
SECTION = "devel/python"
HOMEPAGE = "https://pypi.python.org/pypi/incremental"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6ca9b07f08e2c72d48c74d363d1e0e15"
PR = "r0"

inherit setuptools

SRC_URI = "https://pypi.python.org/packages/8f/26/02c4016aa95f45479eea37c90c34f8fab6775732ae62587a874b619ca097/incremental-${PV}.tar.gz"

S = "${WORKDIR}/incremental-${PV}"

SRC_URI[md5sum] = "602746e0d438e075a5a9e0678140bba2"
SRC_URI[sha256sum] = "7b751696aaf36eebfab537e458929e194460051ccad279c72b755a167eebd4b3"
