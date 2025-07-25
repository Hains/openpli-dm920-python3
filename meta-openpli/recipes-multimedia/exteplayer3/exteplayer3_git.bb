SUMMARY = "exteplayer3 - media player for E2"
DESCRIPTION = "Core of movie player for E2 based on the libeplayer using the ffmpeg solution"
SECTION = "multimedia"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "ffmpeg"
RDEPENDS:${PN} = "ffmpeg"

inherit gitpkgv

PV = "177+gitr"
PKGV = "177+gitr${GITPKGV}"

SRC_URI = "git://github.com/skyjet18/exteplayer3.git;branch=master;protocol=https"

SOURCE_FILES =  "main/exteplayer.c"
SOURCE_FILES =+ "container/container.c"
SOURCE_FILES =+ "container/container_ffmpeg.c"
SOURCE_FILES =+ "manager/manager.c"
SOURCE_FILES =+ "manager/audio.c"
SOURCE_FILES =+ "manager/video.c"
SOURCE_FILES =+ "manager/subtitle.c"
SOURCE_FILES =+ "output/graphic_subtitle.c"
SOURCE_FILES =+ "output/linuxdvb_buffering.c"
SOURCE_FILES =+ "output/linuxdvb_mipsel.c"
SOURCE_FILES =+ "output/output.c"
SOURCE_FILES =+ "output/output_subtitle.c"
SOURCE_FILES =+ "output/writer/common/misc.c"
SOURCE_FILES =+ "output/writer/common/pes.c"
SOURCE_FILES =+ "output/writer/common/writer.c"
SOURCE_FILES =+ "output/writer/mipsel/aac.c"
SOURCE_FILES =+ "output/writer/mipsel/ac3.c"
SOURCE_FILES =+ "output/writer/mipsel/amr.c"
SOURCE_FILES =+ "output/writer/mipsel/bcma.c"
SOURCE_FILES =+ "output/writer/mipsel/divx3.c"
SOURCE_FILES =+ "output/writer/mipsel/dts.c"
SOURCE_FILES =+ "output/writer/mipsel/h264.c"
SOURCE_FILES =+ "output/writer/mipsel/h265.c"
SOURCE_FILES =+ "output/writer/mipsel/lpcm.c"
SOURCE_FILES =+ "output/writer/mipsel/mjpeg.c"
SOURCE_FILES =+ "output/writer/mipsel/mp3.c"
SOURCE_FILES =+ "output/writer/mipsel/mpeg2.c"
SOURCE_FILES =+ "output/writer/mipsel/mpeg4.c"
SOURCE_FILES =+ "output/writer/mipsel/pcm.c"
SOURCE_FILES =+ "output/writer/mipsel/vc1.c"
SOURCE_FILES =+ "output/writer/mipsel/vp.c"
SOURCE_FILES =+ "output/writer/mipsel/wmv.c"
SOURCE_FILES =+ "output/writer/mipsel/writer.c"
SOURCE_FILES =+ "playback/playback.c"
SOURCE_FILES =+ "tools/debug.c"
SOURCE_FILES =+ "tools/strbuffer.c"
SOURCE_FILES =+ "external/ffmpeg/src/bitstream.c"
SOURCE_FILES =+ "external/ffmpeg/src/latmenc.c"
SOURCE_FILES =+ "external/ffmpeg/src/mpeg4audio.c"
SOURCE_FILES =+ "external/ffmpeg/src/xiph.c"
SOURCE_FILES =+ "external/flv2mpeg4/src/m4vencode.c"
SOURCE_FILES =+ "external/flv2mpeg4/src/flvdecoder.c"
SOURCE_FILES =+ "external/flv2mpeg4/src/dcprediction.c"
SOURCE_FILES =+ "external/flv2mpeg4/src/flv2mpeg4.c"
SOURCE_FILES =+ "external/plugins/src/png.c"

do_compile() {
    ${CC} ${SOURCE_FILES} -D_FILE_OFFSET_BITS=64 -D_LARGEFILE64_SOURCE -D_LARGEFILE_SOURCE -DHAVE_FLV2MPEG4_CONVERTER -I${S}/include -I${S}/external -I${S}/external/flv2mpeg4 -I${D}/${libdir} -I${D}/${includedir} -lswscale -ldl -lpthread -lavformat -lavcodec -lavutil -lswresample -o exteplayer3 ${LDFLAGS}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/exteplayer3 ${D}${bindir}
}
