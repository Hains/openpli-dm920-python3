FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " jsoncpp icu"

PV = "3.0.0"

SRCREV = "7846f3dd5d0f848a60d0c3146c3b7290881a8992"

SRC_URI:append = " \
           file://config.xml \
           file://init \
"

inherit update-rc.d gitpkgv

INITSCRIPT_NAME = "gerbera"
INITSCRIPT_PARAMS = "defaults 90"

do_install:append() {
    install -d ${D}${sysconfdir}/gerbera
    install -m 0755 ${UNPACKDIR}/config.xml ${D}${sysconfdir}/gerbera/config.xml
    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${UNPACKDIR}/init ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
    fi
}

FILES:${PN} += "${sysconfdir} ${datadir}/bash-completion"

CONFFILES:${PN} = "${sysconfdir}/gerbera/config.xml"
