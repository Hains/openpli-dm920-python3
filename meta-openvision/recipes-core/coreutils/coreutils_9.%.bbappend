# Provide package coreutils-realpath
PACKAGES =+ "${PN}-realpath"

FILES:${PN}-realpath = "${bindir}/realpath.${PN}"

RRECOMMENDS:${PN}:append:class-target = "${PN}-realpath"

ALTERNATIVE:${PN}-realpath = "realpath"
