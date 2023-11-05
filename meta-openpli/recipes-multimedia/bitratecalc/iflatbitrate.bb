DESCRIPTION = "Converter that provides audio/video bitrate widgets"
LICENSE = "CC-BY-NC-ND-4.0"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

RDEPENDS:${PN} = "bitratecalc"

inherit python3native python3-compileall

SRC_URI = "file://iFlatBitrate.py"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${libdir}/enigma2/python/Components/Converter
	cp  ${B}/iFlatBitrate.py ${D}${libdir}/enigma2/python/Components/Converter/
}

FILES:${PN} = "${libdir}/enigma2/python/Components/Converter/"
