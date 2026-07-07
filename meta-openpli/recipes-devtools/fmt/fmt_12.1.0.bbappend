PV = "12.2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=6ec080902ed8f82f5a97ed13e8042634"

SRC_URI:remove = "git://github.com/fmtlib/fmt;branch=master;protocol=https;tag=${PV}"
SRC_URI:append = "git://github.com/fmtlib/fmt;branch=main;protocol=https;tag=${PV}"

SRCREV = "1be298e1bd68957e4cd352e1f676f00e07dcfb57"
