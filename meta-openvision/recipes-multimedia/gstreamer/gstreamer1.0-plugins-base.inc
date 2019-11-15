require gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+"

DEPENDS += "util-linux iso-codes zlib"

PACKAGES_DYNAMIC =+ "^libgst.*"

PACKAGECONFIG ??= "alsa cdparanoia ogg opus pango theora vorbis"

PACKAGECONFIG[alsa]			= "-Dalsa=enabled,-Dalsa=disabled,alsa-lib"
PACKAGECONFIG[cdparanoia]	= "-Dcdparanoia=enabled,-Dcdparanoia=disabled,cdparanoia"
PACKAGECONFIG[ogg]			= "-Dogg=enabled,-Dogg=disabled,libogg"
PACKAGECONFIG[opus]			= "-Dopus=enabled,-Dopus=disabled,libopus"
PACKAGECONFIG[pango]		= "-Dpango=enabled,-Dpango=disabled,pango"
PACKAGECONFIG[theora]		= "-Dtheora=enabled,-Dtheora=disabled,libtheora"
PACKAGECONFIG[vorbis]		= "-Dvorbis=enabled,-Dvorbis=disabled,libvorbis"
   
FILES_${MLPREFIX}libgsttag-1.0 += "${datadir}/gst-plugins-base/1.0/license-translations.dict"

do_install_append () {
	rm ${WORKDIR}/image/${includedir}/KHR/khrplatform.h
}
