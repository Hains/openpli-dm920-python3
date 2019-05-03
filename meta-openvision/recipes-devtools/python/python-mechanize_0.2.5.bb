DESCRIPTION = "Stateful programmatic web browsing, after Andy Lester's Perl module WWW::Mechanize."
HOMEPAGE = "http://wwwsearch.sourceforge.net/mechanize/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=a7939d3efc8493ae7054e3d2c4644b28"

PR = "r2"

RDEPENDS_${PN} = "python-core python-robotparser"

SRC_URI = "https://pypi.python.org/packages/source/m/mechanize/mechanize-${PV}.tar.gz"

SRC_URI[md5sum] = "32657f139fc2fb75bcf193b63b8c60b2"
SRC_URI[sha256sum] = "2e67b20d107b30c00ad814891a095048c35d9d8cb9541801cebe85684cc84766"

S = "${WORKDIR}/mechanize-${PV}"

inherit setuptools distutils

include python-package-split.inc
