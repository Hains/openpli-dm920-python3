SUMMARY = "Push Notifications that work with just about every platform!"
HOMEPAGE = "https://github.com/caronc/apprise"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1700c468c259a17fcf7f51af33a4a2e"

DEPENDS = "python3-babel-native python3-wheel-native"

RDEPENDS:${PN} = "python3-pyyaml python3-markdown python3-click"

SRC_URI[md5sum] = "4211ae0863839d8733a3f01e4e8091a1"
SRC_URI[sha256sum] = "aeb321737f951860d7cb0a9574159090cbdbcb0f1ba01c6b49c69018380adf8d"

inherit pypi python_setuptools_build_meta

include python3-package-split.inc
