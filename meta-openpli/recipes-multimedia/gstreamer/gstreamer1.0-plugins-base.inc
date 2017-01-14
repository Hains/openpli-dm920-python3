require gstreamer1.0-plugins.inc

SRC_URI_append = "\
		file://0001-Makefile.am-don-t-hardcode-libtool-name-when-running.patch \
		file://0002-Makefile.am-prefix-calls-to-pkg-config-with-PKG_CONF.patch \
		file://0003-riff-add-missing-include-directories-when-calling-in.patch \
		file://0004-rtsp-drop-incorrect-reference-to-gstreamer-sdp-in-Ma.patch \
		"

LICENSE = "GPLv2+ & LGPLv2+"

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'virtual/libx11 libxv', '', d)}"
DEPENDS += "util-linux iso-codes zlib"

inherit gettext

PACKAGES_DYNAMIC =+ "^libgst.*"

PACKAGECONFIG ??= " \
	${GSTREAMER_ORC} \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'alsa', '', d)} \
	gio-unix-2.0 ivorbis ogg theora vorbis cdparanoia pango opus \
	"

X11DEPENDS = "virtual/libx11 libsm libxrender"
X11ENABLEOPTS = "--enable-x --enable-xvideo --enable-xshm"
X11DISABLEOPTS = "--disable-x --disable-xvideo --disable-xshm"

PACKAGECONFIG[x11]			= "${X11ENABLEOPTS},${X11DISABLEOPTS},${X11DEPENDS}"
PACKAGECONFIG[alsa]			= "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[ivorbis]		= "--enable-ivorbis,--disable-ivorbis,tremor"
PACKAGECONFIG[ogg]			= "--enable-ogg,--disable-ogg,libogg"
PACKAGECONFIG[opus]			= "--enable-opus,--disable-opus,libopus"
PACKAGECONFIG[theora]		= "--enable-theora,--disable-theora,libtheora"
PACKAGECONFIG[vorbis]		= "--enable-vorbis,--disable-vorbis,libvorbis"
PACKAGECONFIG[pango]		= "--enable-pango,--disable-pango,pango"
PACKAGECONFIG[gio-unix-2.0]	= "--enable-gio_unix_2_0,--disable-gio_unix_2_0,glib-2.0"
PACKAGECONFIG[visual]		= "--enable-libvisual,--disable-libvisual,libvisual"
PACKAGECONFIG[cdparanoia]	= "--enable-cdparanoia,--disable-cdparanoia,cdparanoia"
PACKAGECONFIG[opus]			= "--enable-opus,--disable-opus,libopus"

EXTRA_OECONF += " \
	--enable-zlib \
	"
    
CACHED_CONFIGUREVARS_append_i586 = " ac_cv_header_emmintrin_h=no ac_cv_header_xmmintrin_h=no"

FILES_${MLPREFIX}libgsttag-1.0 += "${datadir}/gst-plugins-base/1.0/license-translations.dict"

do_compile_prepend() {
        export GIR_EXTRA_LIBS_PATH="${B}/gst-libs/gst/tag/.libs:${B}/gst-libs/gst/video/.libs:${B}/gst-libs/gst/audio/.libs:${B}/gst-libs/gst/rtp/.libs"
}
