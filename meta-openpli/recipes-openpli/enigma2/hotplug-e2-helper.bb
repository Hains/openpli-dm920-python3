DESCIPTION = "helper tool to deliver hotplug events to e2"
MAINTAINER = "PLi team"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://bdpoll.c;startline=9;endline=20;md5=d903287e43d72c0f608fd5b718e88450"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

GITHUB_URI ?= "git://github.com"
SRC_URI = "${GITHUB_URI}/OpenPLi/${BPN}.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit autotools
