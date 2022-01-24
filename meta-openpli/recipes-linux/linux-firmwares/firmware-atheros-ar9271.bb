require linux-firmware.inc

DESCRIPTION = "Firmware for Atheros HTC devices ar9271"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 ar9271.fw ${D}${base_libdir}/firmware
	install -m 0644 LICENCE.atheros_firmware ${D}${base_libdir}/firmware/LICENCE_ar9271.txt
}
