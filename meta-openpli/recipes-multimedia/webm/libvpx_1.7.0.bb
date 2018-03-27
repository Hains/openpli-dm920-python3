SUMMARY = "VPX multi-format codec"
DESCRIPTION = "The BSD-licensed libvpx reference implementation provides en- and decoders for VP8 and VP9 bitstreams."
HOMEPAGE = "http://www.webmproject.org/code/"
BUGTRACKER = "http://code.google.com/p/webm/issues/list"
SECTION = "libs/multimedia"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d5b04755015be901744a78cc30d390d4"

SRC_URI += "https://github.com/webmproject/libvpx/archive/v1.7.0/libvpx-1.7.0.tar.gz \
			file://libvpx-configure-support-blank-prefix.patch \
			"

SRC_URI[md5sum] = "193346f9aec0726145e51db732417cd2"
SRC_URI[sha256sum] = "1fec931eb5c94279ad219a5b6e0202358e94a93a90cfb1603578c326abfc1238"

# ffmpeg links with this and fails
# sysroots/armv4t-oe-linux-gnueabi/usr/lib/libvpx.a(vpx_encoder.c.o)(.text+0xc4): unresolvable R_ARM_THM_CALL relocation against symbol `memcpy@@GLIBC_2.4'
ARM_INSTRUCTION_SET = "arm"

CFLAGS += "-fPIC"

export CC
export LD = "${CC}"

VPXTARGET_armv5te = "armv5te-linux-gcc"
VPXTARGET_armv6 = "armv6-linux-gcc"
VPXTARGET_armv7a = "armv7-linux-gcc"
VPXTARGET ?= "generic-gnu"

CONFIGUREOPTS = " \
    --target=${VPXTARGET} \
    --enable-vp9 \
    --enable-libs \
    --disable-install-docs \
    --disable-static \
    --enable-shared \
    --prefix=${prefix} \
    --libdir=${libdir} \
    --size-limit=16384x16384 \
"

do_configure() {
    ${S}/configure ${CONFIGUREOPTS}
}

do_install() {
    oe_runmake install DESTDIR=${D}
    chown -R root:root ${D}
}
