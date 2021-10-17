require conf/license/license-gplv2.inc

SRC_URI = "file://dataclasses.py"

S = "${WORKDIR}"

PYTHON_MAJMIN = "3.10"

do_install() {
	install -d ${D}${libdir}/python${PYTHON_MAJMIN}
	install -m 0755 ${S}/dataclasses.py ${D}${libdir}/python${PYTHON_MAJMIN}/dataclasses.py
}

FILES:${PN} = "*"
