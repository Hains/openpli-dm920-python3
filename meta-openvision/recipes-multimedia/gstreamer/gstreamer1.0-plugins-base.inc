require gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+"

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'virtual/libx11 libxv', '', d)}"
DEPENDS += "util-linux iso-codes zlib"

inherit gettext gobject-introspection

PACKAGES_DYNAMIC =+ "^libgst.*"

PACKAGECONFIG ??= " \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'alsa', '', d)} \
	orc ivorbis ogg theora vorbis cdparanoia pango opus \
	"

X11DEPENDS 		= "virtual/libx11 libsm libxrender"
X11ENABLEOPTS 	= "--enable-x --enable-xvideo --enable-xshm"
X11DISABLEOPTS 	= "--disable-x --disable-xvideo --disable-xshm"

PACKAGECONFIG[x11]			= "${X11ENABLEOPTS},${X11DISABLEOPTS},${X11DEPENDS}"
PACKAGECONFIG[alsa]			= "--enable-alsa,--disable-alsa,alsa-lib"
PACKAGECONFIG[gles2]		= "--enable-gles2,--disable-gles2,virtual/libgles2"
PACKAGECONFIG[ivorbis]		= "--enable-ivorbis,--disable-ivorbis,tremor"
PACKAGECONFIG[ogg]			= "--enable-ogg,--disable-ogg,libogg"
PACKAGECONFIG[opengl]    	= "--enable-opengl,--disable-opengl,virtual/libgl libglu"
PACKAGECONFIG[opus]			= "--enable-opus,--disable-opus,libopus"
PACKAGECONFIG[theora]		= "--enable-theora,--disable-theora,libtheora"
PACKAGECONFIG[vorbis]		= "--enable-vorbis,--disable-vorbis,libvorbis"
PACKAGECONFIG[pango]		= "--enable-pango,--disable-pango,pango"
PACKAGECONFIG[visual]		= "--enable-libvisual,--disable-libvisual,libvisual"
PACKAGECONFIG[wayland]		= "--enable-wayland --enable-egl,--disable-wayland --disable-egl,wayland virtual/egl"
PACKAGECONFIG[cdparanoia]	= "--enable-cdparanoia,--disable-cdparanoia,cdparanoia"

EXTRA_OECONF += " \
	--enable-zlib \
	--disable-cocoa \
	"
    
CACHED_CONFIGUREVARS_append_i586 = " ac_cv_header_emmintrin_h=no ac_cv_header_xmmintrin_h=no"

FILES_${MLPREFIX}libgsttag-1.0 += "${datadir}/gst-plugins-base/1.0/license-translations.dict"

do_compile_prepend() {
        export GIR_EXTRA_LIBS_PATH="${B}/gst-libs/gst/tag/.libs:${B}/gst-libs/gst/video/.libs:${B}/gst-libs/gst/audio/.libs:${B}/gst-libs/gst/rtp/.libs"
}
