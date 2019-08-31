KV = "3.14-1.17"
DRIVERDATE = "20190830"

require dreambox-dvb-modules.inc

SRC_URI[dm920.md5sum] = "255c4526f32f0730060b31da6af77531"
SRC_URI[dm920.sha256sum] = "a2657e2f53080d8a7673c7c061ef55557fcb63b75eb732bd72853776eca5cbe1"

COMPATIBLE_MACHINE = "dm920"

MD5SUM = "${@d.getVarFlag('SRC_URI', 'dm920.md5sum', True)}"
