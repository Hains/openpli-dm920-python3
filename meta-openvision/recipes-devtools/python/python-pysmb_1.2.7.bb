SUMMARY  = "pysmb is an experimental SMB/CIFS library written in Python"
DESCRIPTION = "pysmb is an experimental SMB/CIFS library written in Python to support file sharing between Windows and Linux machines. It implements the client-side SMB/CIFS protocol which allows your Python application to access and transfer files to/from SMB/CIFS shared folders like your Windows file sharing and Samba folders."
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=21c760b839b67e25d55d6dabc6abee53"

inherit pypi setuptools3

SRCNAME = "pysmb"
SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.zip"

SRC_URI[md5sum] = "985b9a5e9f841fe33fe5f0bdb9ee0f06"
SRC_URI[sha256sum] = "298605b8f467ce15b412caaf9af331c135e88fa2172333af14b1b2916361cb6b"

include python-package-split.inc
