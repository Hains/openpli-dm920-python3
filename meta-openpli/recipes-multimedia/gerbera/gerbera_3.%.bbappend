FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " libzip libzippp"

SRC_URI:append = " \
           file://config.xml \
           file://init \
"
SRC_URI:remove  = "file://0001-fix-build-against-fmt-12-include-fmt-format.h.patch \
                   file://0002-include-cstring-for-std-strerror-std-memcpy.patch \
"

PV = "3.3.0"

SRCREV = "28361d9e22812c9d7042a85b355a17c8f8495217"

PACKAGECONFIG[zip] = "-DWITH_ZIP=TRUE,libzippp libzip"

inherit update-rc.d

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

FILES:${PN} += "${sysconfdir}"

CONFFILES:${PN} = "${sysconfdir}/gerbera/config.xml"
