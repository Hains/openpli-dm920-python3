# dreambox-arm.inc

MTD_ROOTFS = "mmcblk0p2"
MTD_KERNEL = "mmcblk0p1"
KERNEL_FILE = "kernel.bin"
ROOTFS_FILE = "rootfs.tar.bz2"

DISTRO_FEATURES_GFX:mipsel ?= " opengl"

PACKAGECONFIG:pn-glmark2 = "gles2"

PACKAGECONFIG:pn-cogl-1.0 = "egl-kms egl-null \
        ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"

PACKAGECONFIG:pn-weston = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles', '', d)}"

DVBSKYPROVIDER = "kernel"

GLIBC_EXTRA_OECONF = "--with-tls --with-__thread"

DVBMEDIASINK_CONFIG = "--with-machine=${MACHINE} --with-pcm --with-wma --with-wmv --with-dts=no --with-dtsdownmix --with-eac3 --with-vb6 --with-vb8 --with-vb9 --with-spark --with-h265"

require conf/machine/include/soc-family.inc
require conf/machine/include/arm/armv7a/tune-cortexa15.inc

MACHINE_EXTRA_RRECOMMENDS += "\
    gstreamer1.0-plugin-multibox-dvbmediasink \
    gstreamer1.0-libav \
    kernel-module-cifs \
    kernel-module-autofs4 \
    kernel-module-hmac \
    kernel-module-md4 \
    kernel-module-ecb \
    kernel-module-fuse \
    kernel-module-nfsd \
    kernel-module-exportfs \
    kernel-module-snd-oss \
    kernel-module-snd-pcm-oss \
    "

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    dreambox-dvb-modules-${MACHINE} \
    libpagecache \
    libpassthrough \
    "

KERNEL_MODULE_AUTOLOAD += "xfs"

DISTRO_FEATURES:remove = "directfb gtk-directfb"
    
MACHINE_FEATURES += "dreambox alsa usbhost 3dtv switchoff blindscan-dvbs"
# Add "dreambox" override for recipes
MACHINEOVERRIDES .= ":dreambox"

PREFERRED_PROVIDER_virtual/kernel = "linux-dreambox"
PREFERRED_PROVIDER_virtual/blindscan-dvbs = "dreambox-blindscan-utils"
PREFERRED_PROVIDER_virtual/blindscan-dvbc = "dreambox-blindscan-utils"
PREFERRED_VERSION_linux-dreambox ?= "3.14"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa-gl"
PREFERRED_PROVIDER_virtual/mesa ?= "mesa-gl"
PREFERRED_VERSION_linux-dreambox = "3.14"

TARGET_ARCH = "arm"
DEFAULTTUNE = "cortexa15hf-neon-vfpv4"
OLDEST_KERNEL = "3.14"

MACHINE_FEATURES_BACKFILL_CONSIDERED = "rtc gobject-introspection-data"

DREAMBOX_IMAGE_SIZE ??= "1024"

IMAGE_FSTYPES =+ "tar.bz2"

IMAGE_CLASSES += "image_types_tarbz2"
