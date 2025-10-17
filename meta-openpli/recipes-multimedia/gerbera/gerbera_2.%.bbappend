FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " jsoncpp icu"

PV = "pre2.7"

SRCREV = "29924b6d0667eedb9881bf262a764a35f92823dc"

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
