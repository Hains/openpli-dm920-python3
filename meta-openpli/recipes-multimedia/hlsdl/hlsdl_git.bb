DESCRIPTION = "This program converts .m3u8 playlists to a .ts video. It supports decryption of both AES-128 and SAMPLE-AES encryption."
MAINTAINER = "samsamsam"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ec892df81d7a9e0b5cd420bb5603c288"

DEPENDS = "curl"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/samsamsam-iptvplayer/hlsdl.git;protocol=git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
