DESCRIPTION = "sshpass"
LICENSE = "GPL-2.0-or-later"

LIC_FILES_CHKSUM = "file://main.c;beginline=1;endline=19;md5=bb3cd21c281c2ac32d4cb77974a88ae2"

SRC_URI = "http://downloads.sourceforge.net/project/sshpass/sshpass/${PV}/${P}.tar.gz"

inherit autotools-brokensep

do_compile() {
	oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${B}/sshpass ${D}${bindir}/sshpass
}

SRC_URI[md5sum] = "c52d65fdee0712af6f77eb2b60974ac7"
SRC_URI[sha256sum] = "c3f78752a68a0c3f62efb3332cceea0c8a1f04f7cf6b46e00ec0c3000bc8483e"
