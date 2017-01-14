SUMMARY = "decoding library for DTS Coherent Acoustics streams"
SECTION = "libs/multimedia"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
SRCREV = "1c7c6584c2cdb188a6f29eaaa85a2a84c8959395"
PR = "r1"
DEPENDS += "quilt-native"

SRC_URI = "git://anonscm.debian.org/git/collab-maint/${PN}.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools-brokensep lib_package pkgconfig

do_unpackpost() {
		cd ${S}
    QUILT_PATCHES=debian/patches quilt push -a
    # single precision is enough and speeds up libdca by about 10-15%
    sed -i -e 's/double/sample_t/g' ${S}/libdca/*.c ${S}/libdca/*.h
}

addtask unpackpost after do_patch before do_configure
