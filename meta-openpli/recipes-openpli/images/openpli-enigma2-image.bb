inherit image

IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

KERNEL_WIFI_DRIVERS = " \
	firmware-carl9170 \
	firmware-htc7010 \
	firmware-htc9271 \
	firmware-rt2870 \
	firmware-rt73 \
	firmware-rtl8712u \
	firmware-zd1211 \
	\
	kernel-module-ath9k-htc \
	kernel-module-carl9170 \
	kernel-module-r8712u \
	kernel-module-rt2500usb \
	kernel-module-rt2800usb \
	kernel-module-rt73usb \
	kernel-module-rtl8187 \
	kernel-module-zd1211rw \
	"

EXTERNAL_WIFI_DRIVERS = " \
	firmware-rtl8192eu \
	firmware-rtl8188eu \
	\
	rtl8188eu \
	rtl8192eu \
	"

ENIGMA2_PLUGINS = " \
	enigma2-plugin-extensions-audiosync \
	enigma2-plugin-extensions-autobackup \
	enigma2-plugin-extensions-bitrate \
	enigma2-plugin-extensions-cdinfo \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-extensions-dvdplayer \
	enigma2-plugin-extensions-filecommander \
	enigma2-plugin-extensions-foreca \
	enigma2-plugin-extensions-graphmultiepg \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-moviecut \
	enigma2-plugin-extensions-netcaster \
	enigma2-plugin-extensions-openwebif \
	enigma2-plugin-extensions-pictureplayer \
	enigma2-plugin-extensions-systemtools \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-youtube \
	\
	enigma2-plugin-systemplugins-cablescan \
	enigma2-plugin-systemplugins-commoninterfaceassignment \
	enigma2-plugin-systemplugins-fastscan \
	enigma2-plugin-systemplugins-hdmicec \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-osd3dsetup \
	enigma2-plugin-systemplugins-osdpositionsetup \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-systemplugins-satfinder \
	enigma2-plugin-systemplugins-softwaremanager \
	enigma2-plugin-systemplugins-videoenhancement \
	enigma2-plugin-systemplugins-videomode \
	enigma2-plugin-systemplugins-videotune \
	enigma2-plugin-systemplugins-wirelesslan \
	"

DEPENDS += " \
	enigma2 \
	package-index \
	"

IMAGE_INSTALL = " \
	aio-grab \
	avahi-daemon \
	ca-certificates \
	cdtextinfo \
	cifs-utils \
	distro-feed-configs \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	enigma2 \
	fakelocale \
	fuse-exfat \
	glibc-binary-localedata-en-gb \
	hdparm \
	kernel-params \
	libavahi-client \
	modutils-loadscript \
	nfs-utils \
	nfs-utils-client \
	ntp \
	openpli-bootlogo \
	openresolv \
	openssh-sftp-server \
	opkg \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	python3-ipaddress  \
	python3-netifaces \
	python3-pysmb \
	python3-requests \
	sdparm \
	settings-autorestore \
	tuxbox-common \
	tzdata \
	util-linux-ionice \
	volatile-media \
	vsftpd \
	wget \
	${ENIGMA2_PLUGINS} \
	${KERNEL_WIFI_DRIVERS} \
	${EXTERNAL_WIFI_DRIVERS} \
	${ROOTFS_PKGMANAGE} \
	"

export IMAGE_BASENAME = "openpli-enigma2"

# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs:remove_opkg_leftovers but that fails to parse.
removeopkgleftovers() {
	rm -r ${IMAGE_ROOTFS}/var/lib/opkg/lists
}

# Some features in image.bbclass we do NOT want, so override them
# to be empty. We want to log in as root, but NOT via SSH. So we want
# to live without debug-tweaks...
zap_root_password () {
	true
}

ssh_allow_empty_password () {
	true
}

license_create_manifest() {
}

ROOTFS_POSTPROCESS_COMMAND += "removeopkgleftovers; "
