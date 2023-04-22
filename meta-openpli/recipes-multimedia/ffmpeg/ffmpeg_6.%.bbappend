FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
		file://02-fix-hls.patch \
		file://03-buffer-size.patch \
		file://04-aac.patch \
		file://05-fix-mpegts.patch \
		file://06-allow_to_choose_rtmp_impl_at_runtime.patch \
		file://07-fix-edit-list-parsing.patch \
		file://08-hls-replace-key-uri.patch \
		"


EXTRA_FFCONF = " \
	--disable-static \
	--disable-runtime-cpudetect \
	--enable-ffprobe \
	--disable-altivec \
	--disable-amd3dnow \
	--disable-amd3dnowext \
	--disable-mmx \
	--disable-mmxext \
	--disable-sse \
	--disable-sse2 \
	--disable-sse3 \
	--disable-ssse3 \
	--disable-sse4 \
	--disable-sse42 \
	--disable-avx \
	--disable-xop \
	--disable-fma3 \
	--disable-fma4 \
	--disable-avx2 \
	--enable-inline-asm \
	--enable-asm \
	--disable-x86asm \
	--disable-fast-unaligned \
	--enable-muxers \
	--enable-encoders \
	--enable-decoders \
	--enable-demuxers \
	--enable-parsers \
	--enable-bsfs \
	--enable-protocols \
	--enable-indevs \
	--enable-outdevs \
	--enable-filters \
	--disable-doc \
	--disable-htmlpages \
	--disable-manpages \
	--disable-podpages \
	--disable-txtpages \
	--disable-vfp \
	--disable-neon \
	--disable-debug \
	--pkg-config="pkg-config" \
	--enable-zlib \
	--prefix=${prefix} \
"
