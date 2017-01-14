SUMMARY = "Module for manipulating ID3 (v1 + v2) tags in Python"
SECTION = "devel/python"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRCNAME = "mutagen"
PR = "r1"

DEPENDS = "python"
RDEPENDS_${PN} = "python-shell"

SRC_URI = "https://bitbucket.org/lazka/mutagen/downloads/mutagen-${PV}.tar.gz \
		  "

SRC_URI[md5sum] = "5509f20ae750ebe44179174e3595981a"
SRC_URI[sha256sum] = "aacd667ef1f4fa7b7c201f36b2a6eda1ead3c92331017601d8082af62a7ee461"

S = "${WORKDIR}/mutagen-${PV}"

inherit distutils


