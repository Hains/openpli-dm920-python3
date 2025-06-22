require linux-firmware-local.inc

DESCRIPTION = "Firmware for TBS 5980"

S = "${UNPACKDIR}"

FW = "dvb-usb-tbsqbox-id5980.fw"
SRC_URI = "file://${FW}"

do_install() {
        install -d ${D}${base_libdir}/firmware
        install -m 0644 ${FW} ${D}${base_libdir}/firmware
}
