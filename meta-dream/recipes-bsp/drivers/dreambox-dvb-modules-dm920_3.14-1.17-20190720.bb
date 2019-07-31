KV = "3.14-1.17"
DRIVERDATE = "20190720"

require dreambox-dvb-modules.inc

SRC_URI[dm920.md5sum] = "56d9457a7cd0dd07b85f6d91bf0793d6"
SRC_URI[dm920.sha256sum] = "82d11775571d36ce39fc92b2d6ed4be6ae88c1aa71ad188103f89f6c7db00861"

COMPATIBLE_MACHINE = "dm920"

MD5SUM = "${@d.getVarFlag('SRC_URI', 'dm920.md5sum', True)}"
