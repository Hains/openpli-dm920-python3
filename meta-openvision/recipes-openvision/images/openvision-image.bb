require conf/license/openpli-gplv2.inc

inherit image

IMAGE_INSTALL = "\
	${ROOTFS_PKGMANAGE} \
	avahi-daemon \
	ca-certificates \
	dhrystone \
	distro-feed-configs \
	dropbear \
	e2fsprogs-e2fsck \
	e2fsprogs-mke2fs \
	e2fsprogs-tune2fs \
	fakelocale \
	fuse-exfat \
	glibc-binary-localedata-en-gb \
	hdparm \
	kernel-params \
	modutils-loadscript \
	nfs-utils \
	nfs-utils-client \
	openvision-bootlogo \
	openssh-sftp-server \
	opkg \
	packagegroup-base \
	packagegroup-core-boot \
	parted \
	python3-ipaddress  \
	python3-netifaces \
	python-pysmb \
	python3-requests \
	sdparm \
	tuxbox-common \
	util-linux-ionice \
	tzdata \
	volatile-media \
	vsftpd \
"

export IMAGE_BASENAME = "openpli"
IMAGE_LINGUAS = ""
IMAGE_FEATURES += "package-management"

# Remove the mysterious var/lib/opkg/lists that appears to be the result
# of the installer that populates the rootfs. I wanted to call this
# rootfs_remove_opkg_leftovers but that fails to parse.
rootfs_removeopkgleftovers() {
	rm -r ${IMAGE_ROOTFS}/var/lib/opkg/lists
}

# Switch from ssh-rsa to ecdsa-sha2-nistp521, as OpenSSH has deprecated ssh-rsa
rootfs_speedup_dropbearkey() {
	echo 'DROPBEAR_RSAKEY_ARGS="-t ecdsa -s 521"' >> ${IMAGE_ROOTFS}${sysconfdir}/default/dropbear
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

ROOTFS_POSTPROCESS_COMMAND += "rootfs_removeopkgleftovers; rootfs_speedup_dropbearkey; "
