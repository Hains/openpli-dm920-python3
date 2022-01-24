SUMMARY = "Kodi Media Center"

do_compile[network] = "1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=7b423f1c9388eae123332e372451a4f7"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-20:"

PACKAGE_ARCH = "${MACHINE}"

inherit cmake gettext python3-dir pkgconfig  python3native

DEPENDS += " \
            autoconf-native \
            automake-native \
            ninja-native \
            fmt \
            flatbuffers flatbuffers-native \
            fstrcmp \
            rapidjson \
            crossguid \
            libdvdnav libdvdcss libdvdread \
            ffmpeg \
            git-native \
            curl-native \
            gperf-native \
            jsonschemabuilder-native \
            nasm-native \
            swig-native \
            unzip-native \
            yasm-native \
            zip-native \
            \
            avahi \
            boost \
            bzip2 \
            curl \
            libdcadec \
            enca \
            expat \
            faad2 \
            fontconfig \
            fribidi \
            glib-2.0 \ 
            giflib \
            libass \
            libcdio \
            libcec \
            libinput \
            libbluray \
            libmad \
            libmicrohttpd \
            libmms \
            libmodplug \
            libnfs \
            libpcre \
            libplist \
            libsamplerate0 \
            libsquish \
            libssh \
            spdlog \
            libtinyxml \
            libusb1 \
            libxkbcommon \
            libxslt \
            lzo \
            mpeg2dec \
            ${PYTHON_PN} \
            samba \
            sqlite3 \
            taglib \
            virtual/egl \
            wavpack \
            yajl \
            zlib \
            texturepacker-native \
            \
            gstreamer1.0 \
            gstreamer1.0-plugins-base \
          "

# 20.0 Alpha1
SRCREV = "9df7fe699148a5990f86129cba760113a4c72fb0"

# 'patch' doesn't support binary diffs
PATCHTOOL = "git"

PR = "r0"

PV = "20.0-gitr${SRCPV}"

SRC_URI = "git://github.com/xbmc/xbmc.git;protocol=https;branch=master \
           file://0001-flatbuffers-20.patch \
           file://0002-readd-Touchscreen-settings.patch \
           file://0003-crossguid-0.2.patch \
           file://0004-shader-nopow-20.patch \
           file://0006-stb-settings-20.patch \
           file://0005-stb-support-20.patch \
           file://0007-add-winsystemfactory-windowing-init.patch \
           file://0008-adapt-window-system-registration.patch \
           ${@bb.utils.contains_any('MACHINE_FEATURES', 'hisil-3798mv200 hisil-3798mv310 hisi hisil', '' , 'file://0009-e2-player.patch', d)} \
           ${@bb.utils.contains_any('MACHINE_FEATURES', 'hisil-3798mv200 hisil-3798mv310 hisi hisil', '' , 'file://0010-gst-player.patch', d)} \
          "

S = "${WORKDIR}/git"

# breaks compilation
CCACHE_DISABLE = "1"
ASNEEDED = ""

ACCEL ?= ""
ACCEL:x86 = "vaapi vdpau"
ACCEL:x86-64 = "vaapi vdpau"

# Default to GBM everywhere, sucks to be nvidia
WINDOWSYSTEM ?= "stb"

#[cmake] only use APP_RENDER_SYSTEM
#https://github.com/xbmc/xbmc/commit/d159837cf736c9ba17772ba52e4ce95aa3625528
APPRENDERSYSTEM ?= "gles"

PACKAGECONFIG ??= "${ACCEL} ${WINDOWSYSTEM} pulseaudio lcms lto \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl', 'openglesv2', d)}"

# Core windowing system choices

PACKAGECONFIG[x11] = "-DCORE_PLATFORM_NAME=x11,,libxinerama libxmu libxrandr libxtst glew"
PACKAGECONFIG[gbm] = "-DCORE_PLATFORM_NAME=gbm -DGBM_RENDER_SYSTEM=gles,,"
PACKAGECONFIG[stb] = "-DCORE_PLATFORM_NAME=stb,,"
PACKAGECONFIG[raspberrypi] = "-DCORE_PLATFORM_NAME=rbpi,,userland"
PACKAGECONFIG[amlogic] = "-DCORE_PLATFORM_NAME=aml,,"
PACKAGECONFIG[wayland] = "-DCORE_PLATFORM_NAME=wayland -DWAYLAND_RENDER_SYSTEM=gles,,wayland waylandpp"

PACKAGECONFIG[opengl] = "-DENABLE_OPENGL=ON,,"
PACKAGECONFIG[openglesv2] = "-DENABLE_GLES=ON,,virtual/egl"

PACKAGECONFIG[vaapi] = "-DENABLE_VAAPI=ON,-DENABLE_VAAPI=OFF,libva"
PACKAGECONFIG[vdpau] = "-DENABLE_VDPAU=ON,-DENABLE_VDPAU=OFF,libvdpau"
PACKAGECONFIG[mysql] = "-DENABLE_MYSQLCLIENT=ON,-DENABLE_MYSQLCLIENT=OFF,mysql5"
PACKAGECONFIG[pulseaudio] = "-DENABLE_PULSEAUDIO=ON,-DENABLE_PULSEAUDIO=OFF,pulseaudio"
PACKAGECONFIG[lcms] = ",,lcms"

# Compilation tunes

PACKAGECONFIG[gold] = "-DENABLE_LDGOLD=ON,-DENABLE_LDGOLD=OFF"
PACKAGECONFIG[lto] = "-DUSE_LTO=${@oe.utils.cpu_count()},-DUSE_LTO=OFF"

LDFLAGS += "${TOOLCHAIN_OPTIONS}"
LDFLAGS:append:mips = " -latomic"
LDFLAGS:append:mipsel = " -latomic"
LDFLAGS:append:mips64 = " -latomic"
LDFLAGS:append:mips64el = " -latomic"

KODI_ARCH = ""
KODI_ARCH:mips = "-DWITH_ARCH=${TARGET_ARCH}"
KODI_ARCH:mipsel = "-DWITH_ARCH=${TARGET_ARCH}"
KODI_ARCH:mips64 = "-DWITH_ARCH=${TARGET_ARCH}"
KODI_ARCH:mips64el = "-DWITH_ARCH=${TARGET_ARCH}"

KODI_DISABLE_INTERNAL_LIBRARIES = " \
  -DENABLE_INTERNAL_CROSSGUID=OFF \
  -DENABLE_INTERNAL_FLATBUFFERS=OFF \
  -DENABLE_INTERNAL_FMT=OFF \
  -DENABLE_INTERNAL_FSTRCMP=0 \
  -DENABLE_INTERNAL_RapidJSON=OFF \
  -DENABLE_INTERNAL_FFMPEG=OFF \
"

EXTRA_OECMAKE = " \
    ${KODI_ARCH} \
    ${KODI_DISABLE_INTERNAL_LIBRARIES} \
    -DAPP_RENDER_SYSTEM=${APPRENDERSYSTEM} \
    \
    -DNATIVEPREFIX=${STAGING_DIR_NATIVE}${prefix} \
    -DJava_JAVA_EXECUTABLE=/usr/bin/java \
    -DWITH_TEXTUREPACKER=${STAGING_BINDIR_NATIVE}/TexturePacker \
    -DWITH_JSONSCHEMABUILDER=${STAGING_BINDIR_NATIVE}/JsonSchemaBuilder \
    \
    -DCMAKE_NM='${NM}' \
    \
    -DFFMPEG_PATH=${STAGING_DIR_TARGET} \
    -DLIBDVD_INCLUDE_DIRS=${STAGING_INCDIR} \
    -DNFS_INCLUDE_DIR=${STAGING_INCDIR} \
    -DSHAIRPLAY_INCLUDE_DIR=${STAGING_INCDIR} \
    \
    -DENABLE_AIRTUNES=ON \
    -DENABLE_OPTICAL=OFF \
    -DENABLE_DVDCSS=OFF \
    -DENABLE_DEBUGFISSION=OFF \
    -DCMAKE_BUILD_TYPE=RelWithDebInfo \
"

# OECMAKE_GENERATOR="Unix Makefiles"
# PARALLEL_MAKE = " "

FULL_OPTIMIZATION:armv7a = "-fexpensive-optimizations -fomit-frame-pointer -O3 -ffast-math"
FULL_OPTIMIZATION:armv7ve = "-fexpensive-optimizations -fomit-frame-pointer -O3 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

# for python modules
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR
export ${PYTHON_DIR}

export TARGET_PREFIX

do_configure:prepend() {
    # Ensure 'nm' can find the lto plugins 
    liblto=$(find ${STAGING_DIR_NATIVE} -name "liblto_plugin.so.0.0.0")
    mkdir -p ${STAGING_LIBDIR_NATIVE}/bfd-plugins
    ln -sf $liblto ${STAGING_LIBDIR_NATIVE}/bfd-plugins/liblto_plugin.so

    sed -i -e 's:CMAKE_NM}:}${TARGET_PREFIX}gcc-nm:' ${S}/xbmc/cores/DllLoader/exports/CMakeLists.txt
}

INSANE_SKIP:${PN} = "rpaths already-stripped"

FILES:${PN} = "${libdir}/kodi ${libdir}/xbmc"
FILES:${PN} += "${bindir}/kodi ${bindir}/xbmc"
FILES:${PN} += "${datadir}/icons ${datadir}/kodi ${datadir}/xbmc ${datadir}/applications"
FILES:${PN} += "${bindir}/kodi-standalone ${bindir}/xbmc-standalone ${datadir}/xsessions"
FILES:${PN} += "${libdir}/firewalld"
FILES:${PN}-dev = "${includedir}"
FILES:${PN}-dbg += "${libdir}/kodi/.debug ${libdir}/kodi/*/.debug ${libdir}/kodi/*/*/.debug ${libdir}/kodi/*/*/*/.debug"

# kodi uses some kind of dlopen() method for libcec so we need to add it manually
# OpenGL builds need glxinfo, that's in mesa-demos
RRECOMMENDS:${PN}:append = " libcec \
                             libcurl \
                             libnfs \
                             nss \
                             os-release \
                             ${@bb.utils.contains('PACKAGECONFIG', 'x11', 'xrandr xinit mesa-demos', '', d)} \
                             ${PYTHON_PN} \
                             ${PYTHON_PN}-ctypes \
                             ${@bb.utils.contains("PYTHON_PN", "python", "${PYTHON_PN}-lang", "", d)} \
                             ${@bb.utils.contains("PYTHON_PN", "python", "${PYTHON_PN}-re", "", d)} \
                             ${PYTHON_PN}-netclient \
                             ${PYTHON_PN}-html \
                             ${PYTHON_PN}-difflib \
                             ${PYTHON_PN}-json \
                             ${@bb.utils.contains("PYTHON_PN", "python", "${PYTHON_PN}-zlib", "", d)} \
                             ${PYTHON_PN}-shell \
                             ${PYTHON_PN}-sqlite3 \
                             ${PYTHON_PN}-compression \
                             ${PYTHON_PN}-xmlrpc \
                             ${PYTHON_PN}-pycryptodomex \
                             ${PYTHON_PN}-mechanize \
                             ${PYTHON_PN}-profile \
                             tzdata-africa \
                             tzdata-americas \
                             tzdata-antarctica \
                             tzdata-arctic \
                             tzdata-asia \
                             tzdata-atlantic \
                             tzdata-australia \
                             tzdata-europe \
                             tzdata-pacific \
                             xkeyboard-config \
                             kodi-addon-inputstream-adaptive-matrix \
                             kodi-addon-inputstream-rtmp-matrix \
                             alsa-plugins \
                           "

RRECOMMENDS:${PN}:append:libc-glibc = " glibc-charmap-ibm850 \
                                        glibc-gconv-ibm850 \
                                        glibc-charmap-ibm437 \
                                        glibc-gconv-ibm437 \
                                        glibc-gconv-unicode \
                                        glibc-gconv-utf-32 \
                                        glibc-charmap-utf-8 \
                                        glibc-localedata-en-us \
                                      "
