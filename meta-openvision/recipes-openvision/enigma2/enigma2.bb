SUMMARY = "GUI frontend for Open Source Linux based receivers"
DESCRIPTION = "Enigma2 is a framebuffer based frontend for DVB functions on Linux settop boxes"
MAINTAINER = "OpenPLi team <info@openpli.org>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = " \
	avahi \
	freetype \
	gettext-native \
	jpeg \
	libdreamdvd libdvbsi++ fribidi libmad libpng libsigc++-2.0 giflib libxml2 \
	openssl libudfread \
	python-imaging python-twisted python-wifi \
	swig-native \
	tuxtxt-enigma2 \
	"

# SoftcamSetup is integrated now
RREPLACES_${PN} = "enigma2-plugin-pli-softcamsetup"
RCONFLICTS_${PN} = "enigma2-plugin-pli-softcamsetup"

RDEPENDS_${PN} = " \
	alsa-conf \
	enigma2-fonts \
	ethtool \
	glibc-gconv-iso8859-15 \
	openvision-branding \
	${PYTHON_RDEPS} \
	"

RRECOMMENDS_${PN} = " \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-octetfhd \
	hotplug-e2-helper \
	glibc-gconv-utf-16 \
	python-sendfile \
	virtual/enigma2-mediaservice \
	"

PYTHON_RDEPS = " \
	python-codecs \
	python-core \
	python-crypt \
	python-fcntl \
	python-lang \
	python-logging \
	python-netclient \
	python-netserver \
	python-numbers \
	python-pickle \
	python-process \
	python-pyusb \
	python-re \
	python-service-identity \
	python-shell \
	python-threading \
	python-twisted-core \
	python-twisted-web \
	python-xml \
	python-zlib \
	python-zopeinterface \
	"

# DVD and iso playback is integrated, we need the libraries
RDEPENDS_${PN} += "libdreamdvd libudfread"
RRECOMMENDS_${PN} += "libdvdcss"

# We depend on the font which we use for TXT subtitles (defined in skin_subtitles.xml)
RDEPENDS_${PN} += "font-valis-enigma"

RDEPENDS_${PN} += "virtual/blindscan-dvbc"

DEMUXTOOL ?= "replex"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "python-twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "python-twisted-web"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant iw python-wifi"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"
# Note that these tools lack recipes
RDEPENDS_enigma2-plugin-extensions-dvdburn = "dvd+rw-tools dvdauthor mjpegtools cdrkit python-imaging ${DEMUXTOOL}"
RDEPENDS_enigma2-plugin-systemplugins-hotplug = "hotplug-e2-helper"

# Fake package that doesn't actually get built, but allows OE to detect
# the RDEPENDS for the plugins above, preventing [build-deps] warnings.
RDEPENDS_${PN}-build-dependencies = "\
	aio-grab \
	dvd+rw-tools dvdauthor mjpegtools cdrkit python-imaging ${DEMUXTOOL} \
	wpa-supplicant iw python-wifi \
	python-twisted-web \
	"

inherit gitpkgv pythonnative

PV = "2.7+git${SRCPV}"
PKGV = "2.7+git${GITPKGV}"

ENIGMA2_BRANCH ?= "develop"
GITHUB_URI ?= "git://github.com"

SRC_URI = " ${GITHUB_URI}/OpenVisionE2/enigma2-openvision.git;branch=${ENIGMA2_BRANCH} \
			file://001-set-default-debug-level-at-4.patch \
			file://002-set-oeversion-to-92.patch \
			file://004-update-about-screen.patch \
			file://005-set-box-brand-to-dreambox.patch \
			file://006-make-PLi-FullNightHD-skin-default.patch \
			file://011-fix-hardware-name.patch \
			file://012-set-default-hide-channel-list-radio.patch \
			file://013-Revert-startwizard.xml-Add-PESpeedUp.patch \
			"

LDFLAGS_prepend = " -lxml2 "

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/keymaps"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta ${PN}-build-dependencies"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

PACKAGES =+ "enigma2-fonts"
PKGV_enigma2-fonts = "2018.08.15"
FILES_enigma2-fonts = "${datadir}/fonts"

def get_crashaddr(d):
    if d.getVar('CRASHADDR', True):
        return '--with-crashlogemail="${CRASHADDR}"'
    else:
        return ''

EXTRA_OECONF = "\
	--with-libsdl=no --with-boxtype=${MACHINE} \
	--enable-dependency-tracking \
	--with-colorlcd400 \
	--with-oever="9.2" \
	ac_cv_prog_c_openmp=-fopenmp \
	${@get_crashaddr(d)} \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

# pass the enigma branch to automake
EXTRA_OEMAKE = "\
	ENIGMA2_BRANCH=${ENIGMA2_BRANCH} \
	"

# some plugins contain so's, their stripped symbols should not end up in the enigma2 package
FILES_${PN}-dbg += "\
	${libdir}/enigma2/python/Plugins/*/*/.debug \
	"

# Swig generated 200k enigma.py file has no purpose for end users
# Save some space by not installing sources (mytest.py must remain)
FILES_${PN}-src += "\
	${libdir}/enigma2/python/GlobalActions.py \
	${libdir}/enigma2/python/Navigation.py \
	${libdir}/enigma2/python/NavigationInstance.py \
	${libdir}/enigma2/python/RecordTimer.py \
	${libdir}/enigma2/python/ServiceReference.py \
	${libdir}/enigma2/python/SleepTimer.py \
	${libdir}/enigma2/python/e2reactor.py \
	${libdir}/enigma2/python/enigma.py \
	${libdir}/enigma2/python/keyids.py \
	${libdir}/enigma2/python/keymapparser.py \
	${libdir}/enigma2/python/skin.py \
	${libdir}/enigma2/python/timer.py \
	${libdir}/enigma2/python/BoxBrandingTest.py \
	${libdir}/enigma2/python/PowerTimer.py \
	${libdir}/enigma2/python/*/*.py \
	${libdir}/enigma2/python/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*.py \
	${libdir}/enigma2/python/*/*/*/*/*/*.py \
	"

do_install_append() {
	install -d ${D}${datadir}/keymaps
	find ${D}${libdir}/enigma2/python/ -name '*.pyc' -exec rm {} \;
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.py$', 'enigma2-plugin-%s-src', '%s (sources)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True, extra_depends='')
}
