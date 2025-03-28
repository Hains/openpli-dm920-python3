# Creates the "feed", packages not required for the image
# but that should be built for the feed so that other
# components may use them and install on demand.

# We have a GPLv2 license for this recipe...
require conf/license/openpli-gplv2.inc

# Depend on the image, so that it gets build
DEPENDS = "openpli-enigma2-image package-index-feed"

OPTIONAL_PACKAGES_BROKEN = ""
OPTIONAL_PACKAGES ?= ""
OPTIONAL_BSP_PACKAGES ?= ""

OPTIONAL_WIFI_PACKAGES = "\
	kernel-module-rt8812au \
	kernel-module-rt8814au \
	kernel-module-rt5572sta \
	kernel-module-rt8188eu \
	kernel-module-rt8188fu \
	kernel-module-rt3573sta \
	kernel-module-mt7601usta \
	kernel-module-mt7610u \
	kernel-module-rt8723a \
	kernel-module-rt8723bu \
	kernel-module-rt88x2cu \
	kernel-module-rt8192fu \
	kernel-module-rt8852cu \
	kernel-module-rt8723bs \
	kernel-module-rt8821cu \
	kernel-module-rt8192eu \
	kernel-module-rt88x2bu \
	kernel-module-rt8189es \
	\
	firmware-rtl8723bu \
	firmware-rtl8188eu  \
	firmware-rtl8188fu  \
	firmware-rtl8192eu \
	firmware-mt7601u \
	"

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
	djmount \
	dosfstools \
	dvb-apps \
	dvblast \
	dvbsnoop \
	dvdfs \
	edid-decode \
	evtest \
	exfatprogs \
	exteplayer3 \
	gdb \
	gerbera \
	google-dns \
	grep \
	gstplayer \
	hddtemp \
	hdparm \
	htop \
	iflatbitrate \
	inadyn-mt \
	inetutils \
	iperf3 \
	iproute2 \
	iputils \
	joe \
	less \
	libbluray \
	libudfread \
	mc \
	mediainfo \
	minisatip \
	mpd \
	mtd-utils \
	mtools \
	mtr \
	nano \
	net-tools \
	ntfs-3g \
	openmultiboot \
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
	python3-daap \
	python3-future \
	python3-levenshtein \
	python3-lxml \
	python3-mechanize \
	python3-ntplib \
	python3-pysnmp \
	python3-requests \
	python3-transmissionrpc \
	python3-yenc \
	python3-youtube-dl \
	rclone \
	redsea \
	rsync \
	rtl-sdr \
	rtorrent \
	sabnzbd \
	samba \
	satipclient \
	satpi \
	screen \
	sed \
	shairplay \
	smartmontools \
	smbnetfs \
	sshpass \
	strace \
	streamlink \
	streamlinksrv \
	tcpdump \
	tmux \
	transmission \
	udpxy \
	upx \
	usb-modeswitch \
	usb-modeswitch-data \
	ushare \
	v4l-utils \
	vim \
	wget \
	wscan \
	wireless-tools \
	xfsprogs \
	yafc \
	zeroconf \
	zerotier \
	zip \
	zsh \
	${OPTIONAL_BSP_PACKAGES} \
	${OPTIONAL_WIFI_PACKAGES} \
	"

OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""
ENIGMA2_OPTIONAL = " \
	channelsettings-enigma2-meta \
	dvb-usb-drivers-meta \
	enigma2-binary-plugins \
	enigma2-plugin-drivers-usbserial \
	enigma2-plugin-extensions-autobouquets \
	enigma2-plugin-extensions-automatic-fullbackup \
	enigma2-plugin-extensions-bouquetmakerxtream \
	enigma2-plugin-extensions-dlnabrowser \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-fontinfo \
	enigma2-plugin-extensions-freechannels \
	enigma2-plugin-extensions-fritzcall \
	enigma2-plugin-extensions-hdmitest \
	enigma2-plugin-extensions-hetweer \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-infobarweather \
	enigma2-plugin-extensions-iptv-org-playlists \
	enigma2-plugin-extensions-jediepgxtream \
	enigma2-plugin-extensions-jedimakerxtream \
	enigma2-plugin-extensions-moviemanager \
	enigma2-plugin-extensions-ppanel \
	enigma2-plugin-extensions-serienrecorder \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-extensions-sundtekcontrolcenter \
	enigma2-plugin-extensions-ts-sateditor \
	enigma2-plugin-extensions-vcs \
	enigma2-plugin-extensions-xmodem \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-security-firewall \
	enigma2-plugin-skins-e2darkos \
	enigma2-plugin-skins-pd1loi-hd-night \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-skins-simple-gray \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-devicemanager \
	enigma2-plugin-systemplugins-extnumberzap \
	enigma2-plugin-systemplugins-extrafancontrol \
	enigma2-plugin-systemplugins-hrtunerproxy \
	enigma2-plugin-systemplugins-m3uiptv \
	enigma2-plugin-systemplugins-misplslcnscan \
	enigma2-plugin-systemplugins-mountmanager \
	enigma2-plugin-systemplugins-newvirtualkeyboard \
	enigma2-plugin-systemplugins-satipserver \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-systemplugins-signalfinder \
	enigma2-plugin-systemplugins-terrestrialbouquet \
	enigma2-plugin-systemplugins-terrestrialscan \
	enigma2-plugins \
	meta-enigma2-dvdburn \
	packagegroup-openplugins \
	picons-enigma2-meta \
	softcams-enigma2-meta \
	${OPTIONAL_BSP_ENIGMA2_PACKAGES} \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${ENIGMA2_OPTIONAL}"
