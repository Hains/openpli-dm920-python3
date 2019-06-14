require gstreamer1.0-plugins.inc

LICENSE = "GPLv2+ & LGPLv2+ & LGPLv2.1+"

DEPENDS += "gstreamer1.0-plugins-base"

inherit gettext bluetooth gobject-introspection

PACKAGECONFIG ??= " \
	${GSTREAMER_ORC} \
	${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'bluez', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'directfb', 'directfb', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)} \
	bz2 curl dash dtls hls rsvg sbc smoothstreaming sndfile uvch264 webp \
	orc faac faad libmms rtmp \
	"

PACKAGECONFIG[assrender]		= "--enable-assrender,--disable-assrender,libass"
PACKAGECONFIG[bluez]			= "--enable-bluez,--disable-bluez,${BLUEZ}"
PACKAGECONFIG[bz2]				= "--enable-bz2,--disable-bz2,bzip2"
PACKAGECONFIG[curl]				= "--enable-curl,--disable-curl,curl"
PACKAGECONFIG[dash]				= "--enable-dash,--disable-dash,libxml2"
PACKAGECONFIG[directfb]			= "--enable-directfb,--disable-directfb,directfb"
PACKAGECONFIG[dtls]				= "--enable-dtls,--disable-dtls,openssl"
PACKAGECONFIG[faac]				= "--enable-faac,--disable-faac,faac"
PACKAGECONFIG[faad]				= "--enable-faad,--disable-faad,faad2"
PACKAGECONFIG[flite]			= "--enable-flite,--disable-flite,flite-alsa"
PACKAGECONFIG[fluidsynth]		= "--enable-fluidsynth,--disable-fluidsynth,fluidsynth"
PACKAGECONFIG[hls]				= "--enable-hls,--disable-hls,nettle"
PACKAGECONFIG[libmms]			= "--enable-libmms,--disable-libmms,libmms"
PACKAGECONFIG[libssh2]			= "--enable-libssh2,--disable-libssh2,libssh2"
PACKAGECONFIG[modplug]			= "--enable-modplug,--disable-modplug,libmodplug"
PACKAGECONFIG[openal]			= "--enable-openal,--disable-openal,openal-soft"
PACKAGECONFIG[opencv]			= "--enable-opencv,--disable-opencv,opencv"
PACKAGECONFIG[openh264]			= "--enable-openh264,--disable-openh264,openh264"
PACKAGECONFIG[openjpeg]			= "--enable-openjpeg,--disable-openjpeg,openjpeg"
PACKAGECONFIG[openmpt]			= "--enable-openmpt,--disable-openmpt,libopenmpt"
# the opus encoder/decoder elements are now in the -base package,
# but the opus parser remains in -bad
PACKAGECONFIG[opusparse]		= "--enable-opus,--disable-opus,libopus"
PACKAGECONFIG[resindvd]			= "--enable-resindvd,--disable-resindvd,libdvdread libdvdnav"
PACKAGECONFIG[rsvg]				= "--enable-rsvg,--disable-rsvg,librsvg"
PACKAGECONFIG[rtmp]				= "--enable-rtmp,--disable-rtmp,rtmpdump"
PACKAGECONFIG[sbc]				= "--enable-sbc,--disable-sbc,sbc"
PACKAGECONFIG[smoothstreaming]	= "--enable-smoothstreaming,--disable-smoothstreaming,libxml2"
PACKAGECONFIG[sndfile]			= "--enable-sndfile,--disable-sndfile,libsndfile1"
PACKAGECONFIG[srtp]				= "--enable-srtp,--disable-srtp,libsrtp"
PACKAGECONFIG[uvch264]			= "--enable-uvch264,--disable-uvch264,libusb1 libgudev"
PACKAGECONFIG[voaacenc]			= "--enable-voaacenc,--disable-voaacenc,vo-aacenc"
PACKAGECONFIG[voamrwbenc]		= "--enable-voamrwbenc,--disable-voamrwbenc,vo-amrwbenc"
PACKAGECONFIG[webp]				= "--enable-webp,--disable-webp,libwebp"

# these plugins have not been ported to 1.0 (yet):
# dc1394 lv2 musepack teletextdec 
# gsettings cdxaparse dccp faceoverlay hdvparse mve nuvdemux
# patchdetect real sdi videomeasure gsettings

# these plugins have no corresponding library in OE-core or meta-openembedded:
# openni2 winks direct3d directsound winscreencap
# apple_media android_media avc bs2b chromaprint dts gme gsm kate ladspa
# libde265 mimic mpeg2enc mplex ofa openh264 opensles soundtouch spandsp
# wasapi x265 zbar

EXTRA_OECONF += " \
	--enable-decklink \
	--enable-dvb \
	--enable-fbdev \
	--enable-shm \
	--disable-android_media \
	--disable-apple_media \
	--disable-bs2b \
	--disable-chromaprint \
	--disable-dc1394 \
	--disable-direct3d \
	--disable-directsound \
	--disable-dts \
	--disable-gme \
	--disable-gsm \
	--disable-kate \
	--disable-ladspa \
	--disable-libde265 \
	--disable-lv2 \
	--disable-mpeg2enc \
	--disable-mplex \
	--disable-musepack \
	--disable-ofa \
	--disable-openexr \
	--disable-openh264 \
	--disable-openjpeg \
	--disable-openni2 \
	--disable-opensles \
	--disable-soundtouch \
	--disable-spandsp \
	--disable-teletextdec \
	--disable-wasapi \
	--disable-wildmidi \
	--disable-winks \
	--disable-winscreencap \
	--disable-x265 \
	--disable-zbar \
	${@bb.utils.contains("TUNE_FEATURES", "mx32", "--disable-yadif", "", d)} \
	"

export OPENCV_PREFIX = "${STAGING_DIR_TARGET}${prefix}"

ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"

FILES_${PN}-dev += "${libdir}/gstreamer-${LIBV}/include/gst/gl/gstglconfig.h"
FILES_${PN}-freeverb += "${datadir}/gstreamer-${LIBV}/presets/GstFreeverb.prs"
FILES_${PN}-opencv += "${datadir}/gst-plugins-bad/${LIBV}/opencv*"
FILES_${PN}-voamrwbenc += "${datadir}/gstreamer-${LIBV}/presets/GstVoAmrwbEnc.prs"
