DESCRIPTION = "USB serial drivers"

require conf/license/openpli-gplv2.inc

RDEPENDS:${PN} = "kernel-module-usbserial kernel-module-ftdi-sio kernel-module-pl2303 kernel-module-belkin-sa kernel-module-keyspan"

PV = "1.0"

ALLOW_EMPTY:${PN} = "1"
