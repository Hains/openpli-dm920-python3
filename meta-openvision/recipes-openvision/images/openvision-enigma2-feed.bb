# Creates the "feed", packages not required for the image
# but that should be built for the feed so that other
# components may use them and install on demand.

# We have a GPLv2 license for this recipe...
require conf/license/openpli-gplv2.inc

# Depend on the image, so that it gets build
DEPENDS = "openvision-enigma2-image"

OPTIONAL_PACKAGES_BROKEN = ""
OPTIONAL_PACKAGES ?= ""
OPTIONAL_BSP_PACKAGES ?= ""
OPTIONAL_PACKAGES += " \
	astra-sm \
	autofs \
	autossh \
	ccid \
	cloudflare-dns \
	ctorrent \
	cups \
	davfs2 \
	diffutils \
	dosfstools \
	dvb-apps \
	dvblast \
	dvbsnoop \
	dvdfs \
	edid-decode \
	evtest \
	exfat-utils \
	exteplayer3 \
	gdb \
	google-dns \
	grep \
	gstplayer \
	hddtemp \
	hdparm \
	htop \
	inadyn-mt \
	inetutils \
	iperf3 \
	iproute2 \
	iputils \
	joe \
	kodi \
	less \
	libbluray \
	libudfread \
	mc \
	mediainfo \
	minisatip \
	mpd \
	mt7601u \
	mt7610u \
	mtd-utils \
	mtools \
	nano \
	net-tools \
	ntfs-3g \
	ntp \
	nodejs \
	openresolv \
	openssh \
	openvpn \
	parted \
	picocom \
	ppp \
	procps \
	pv \
	pyload \
	python3-beautifulsoup4 \
	python-js2py \
	python3-lxml \
	python3-mechanize \
	python3-ntplib \
	python3-pysnmp \
	python3-requests \
	rsync \
	rt3573 \
	rt5572 \
	rtl8723a \
	rtl8723bs \
	rtl8814au \
	rtl8822bu \
	rt8812au \
	rtl-sdr \
	rtorrent \
	sabnzbd \
	samba \
	satipclient \
	screen \
	sed \
	smartmontools \
	smbnetfs \
	sshpass \
	strace \
	tcpdump \
	tmux \
	transmission \
	udpxy \
	usb-modeswitch \
	usb-modeswitch-data \
	v4l-utils \
	vim \
	wget \
	wscan \
	wireless-tools \
	xfsprogs \
	yafc \
	zeroconf \
	zip \
	zsh \
	${OPTIONAL_BSP_PACKAGES} \
	"

OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""
ENIGMA2_OPTIONAL = " \
	channelsettings-enigma2-meta \
	dvb-usb-drivers-meta \
	enigma2-plugin-drivers-usbserial \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-hetweer \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-extensions-kodi \
	enigma2-plugin-security-firewall \
	enigma2-plugin-skins-octetfhd \
	enigma2-plugin-skins-pd1loi-hd-night \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-systemplugins-newvirtualkeyboard \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugins \
	meta-enigma2-dvdburn \
	picons-enigma2-meta \
	softcams-enigma2-meta \
	${OPTIONAL_BSP_ENIGMA2_PACKAGES} \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${ENIGMA2_OPTIONAL}"
