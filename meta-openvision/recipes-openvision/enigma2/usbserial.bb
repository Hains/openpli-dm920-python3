DESCRIPTION = "meta package for usbserial drivers"
RDEPENDS:${PN} = "kernel-module-usbserial kernel-module-ftdi-sio kernel-module-pl2303 kernel-module-belkin-sa kernel-module-keyspan"

require conf/license/openpli-gplv2.inc

PV = "1.0"

ALLOW_EMPTY:${PN} = "1"
