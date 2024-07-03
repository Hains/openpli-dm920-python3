SUMMARY = "A lightweight RDS decoder"
DESCRIPTION = "redsea is an experiment at building a lightweight command-line RDS decoder for Linux/OSX. It works with any RTL-SDR USB radio stick using the rtl_fm tool. It can also decode raw ASCII bitstream, the hex format used by RDS Spy, and multiplex signals (MPX)."
MAINTAINER = "Oona Räisänen <windyoona@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=884926124e31c67b8c1bdaa062802dec"

inherit gittag

PV = "git${SRCPV}"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/windytan/redsea.git;protocol=https;branch=master \
           file://fix-include-header-file.patch \
"

S = "${WORKDIR}/git"

DEPENDS = "nlohmann-json liquid-dsp virtual/libiconv libsndfile1"

inherit meson pkgconfig gettext
