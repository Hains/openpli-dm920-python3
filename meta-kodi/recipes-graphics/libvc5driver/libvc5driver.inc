SUMMARY = "Broadcom VC5 driver"

FILES_${PN} = "${libdir}/lib*${SOLIBSDEV}"
FILES_${PN}-dev = "${includedir}"

EXCLUDE_FROM_WORLD = "1"

INSANE_SKIP_${PN} = "dev-so"

SRC_URI += "file://LICENSE-CLOSE \
			file://define-broadcom-platform.patch \
"

do_license() {
	mv ${WORKDIR}/LICENSE-CLOSE ${B}/LICENSE-CLOSE
}

do_install_prepend () {
	rm -r ${B}${includedir}/KHR
}

addtask do_license before do_populate_lic after do_unpack
