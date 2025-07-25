SUMMARY = "IPTV bouquet maker"
DESCRIPTION = "Bouquet Maker Xtream"
HOMEPAGE = "https://github.com/kiddac/Bouquet_Maker_Xtream"
MAINTAINER = "kiddac"
PRIORITY = "optional"
require conf/license/license-gplv2.inc

PV = "git"
PKGV = "${GITPKGVTAG}"
PR = "r3"

inherit gitpkgv allarch

RDEPENDS:${PN} = "python3 python3-requests python3-pillow"

SRC_URI = "git://github.com/kiddac/Bouquet_Maker_Xtream.git;protocol=https;branch=master"

FILES:${PN} = " ${libdir}/enigma2/python/Plugins/Extensions/BouquetMakerXtream \
                ${libdir}/enigma2/python/Components/Renderer \
                ${sysconfdir} \
"

CONFFILES:${PN} = "${sysconfdir}/enigma2/bouquetmakerxtream/playlists.txt"

do_install() {
    install -d ${D}${sysconfdir}/enigma2/bouquetmakerxtream
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/BouquetMakerXtream
    install -d ${D}${libdir}/enigma2/python/Components/Renderer ${D}${libdir}/enigma2/python/Components/Renderer
    cp -rf ${S}/BouquetMakerXtream/usr/lib/enigma2/python/Plugins/Extensions/BouquetMakerXtream/* ${D}${libdir}/enigma2/python/Plugins/Extensions/BouquetMakerXtream
    cp -rf ${S}/BouquetMakerXtream/usr/lib/enigma2/python/Components/Renderer/* ${D}${libdir}/enigma2/python/Components/Renderer
}

