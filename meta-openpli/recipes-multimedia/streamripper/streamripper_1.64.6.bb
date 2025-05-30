SUMMARY = "StreamRipper lets you record streaming mp3 to your hard drive."
SECTION = "console/multimedia"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"
DEPENDS = "libogg libvorbis faad2 glib-2.0 libmad"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/streamripper/streamripper-${PV}.tar.gz \
           file://fix-build-with-gcc15.patch \
"

SRC_URI[md5sum] = "a37a1a8b8f9228522196a122a1c2dd32"
SRC_URI[sha256sum] = "c1d75f2e9c7b38fd4695be66eff4533395248132f3cc61f375196403c4d8de42"

EXTRA_OECONF = "--disable-oggtest \
		--disable-vorbistest \
		--with-ogg=${STAGING_LIBDIR} \
		--with-vorbis=${STAGING_LIBDIR}"

inherit autotools pkgconfig

# Fixup for missing "foreign" and "subdir-objects" in automake
do_configure:prepend() {
	sed -i 's/AM_INIT_AUTOMAKE.*$/AM_INIT_AUTOMAKE([foreign subdir-objects])/' ${S}/configure.ac ${S}/*/configure.ac
}
