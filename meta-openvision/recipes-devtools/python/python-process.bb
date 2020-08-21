SUMMARY = "Python process list module"
SECTION = "devel/python"
PRIORITY = "optional"
SRCNAME = "process"

require conf/license/license-gplv2.inc

inherit distutils3-base

PV = "1.0"
PKGV = "1.0"

SRC_URI = "file://process.py"

S = "${WORKDIR}"

FILES_${PN} = "${PYTHON_SITEPACKAGES_DIR}/process.py"

do_compile() {
    python3 -O -m compileall ${WORKDIR}/process.py
}

do_install() {
    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
    install -m 644 ${S}/process.py ${D}${PYTHON_SITEPACKAGES_DIR}/
}
