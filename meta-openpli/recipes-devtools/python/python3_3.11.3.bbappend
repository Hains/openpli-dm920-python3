FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:remove = "http://www.python.org/ftp/python/3.11.3/Python-3.11.3.tar.xz"
SRC_URI:append = " http://www.python.org/ftp/python/3.11.4/Python-3.11.4.tar.xz"

SRC_URI[sha256sum] = "2f0e409df2ab57aa9fc4cbddfb976af44e4e55bf6f619eee6bc5c2297264a7f6"

PV = "3.11.4"
PKGV = "3.11.4"
