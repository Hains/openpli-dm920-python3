DESCRIPTION = "serviceapp service for enigma2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "enigma2 uchardet openssl"
RDEPENDS_${PN} = "enigma2 uchardet openssl python3-json"
RRECOMMENDS_${PN} = "exteplayer3 gstplayer"

SRC_URI = "git://github.com/OpenVisionE2/serviceapp.git;branch=develop"

S = "${WORKDIR}/git"

inherit autotools gitpkgv python3native pkgconfig

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.la"

