DESCRIPTION = "autossh"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://autossh.c;beginline=1;endline=24;md5=755a81ffe573faf6c18d1f1061d097c4"

SRC_URI = "https://mirrorservice.org/sites/ftp.debian.org/debian/pool/main/a/autossh/autossh_1.4e.orig.tar.gz"

inherit autotools-brokensep

TARGET_CC_ARCH += "${LDFLAGS}"

# Install target is broken (attempts to install in /usr/ and ignores
# DESTDIR environment)
do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/autossh ${D}${bindir}/autossh
}

SRC_URI[md5sum] = "f86684b96e99d22b2e9d35dc63b0aa29"
SRC_URI[sha256sum] = "9e8e10a59d7619176f4b986e256f776097a364d1be012781ea52e08d04679156"
