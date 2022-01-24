# make sure it starts automatically after installation
INITSCRIPT_NAME = "openvpn"
INITSCRIPT_PARAMS = "defaults"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

inherit update-rc.d
