DESCRIPTION = "Enigma2 plugin to launch and play media from Kodi"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PV = "20"

RDEPENDS:${PN} += "virtual/kodi kodi-addons-meta"

RRECOMMENDS:${PN} = "enigma2-plugin-extensions-subssupport"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/kueken/kodiext.git;protocol=https;branch=py3 \
		file://advancedsettings.xml \
"

S = "${WORKDIR}/git"

do_install:append() {
	install -d ${D}/usr/share/kodi/system
	install -m 0755 ${WORKDIR}/advancedsettings.xml ${D}/usr/share/kodi/system
}

FILES:${PN} = " \
    ${libdir}/enigma2/python/Plugins/Extensions/Kodi \
    ${bindir}/kodiext \
    /usr/share/kodi/system \
    "

inherit autotools
INSANE_SKIP += "file-deps"
