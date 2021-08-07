SUMMARY = "Broadcom VC5 driver"

FILES:${PN} = "${libdir}/lib*${SOLIBSDEV}"
FILES:${PN}-dev = "${includedir}"

EXCLUDE_FROM_WORLD = "1"

INSANE_SKIP:${PN} = "dev-so installed-vs-shipped"

SRC_URI += "file://LICENSE-CLOSE"

do_license() {
	mv ${WORKDIR}/LICENSE-CLOSE ${B}/LICENSE-CLOSE
}

addtask do_license before do_populate_lic after do_unpack
