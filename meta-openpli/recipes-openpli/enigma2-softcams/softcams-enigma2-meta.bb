DESCRIPTION = "meta file for enigma2 softcam packages"

require conf/license/openpli-gplv2.inc

PROVIDES = "softcams"

DEPENDS_append_mipsel = "\
	enigma2-plugin-softcams-cccam \
	"
DEPENDS += "enigma2-plugin-softcams-oscam-emu"
