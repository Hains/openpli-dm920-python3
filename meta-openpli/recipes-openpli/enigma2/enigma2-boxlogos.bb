DESCRIPTION = "Box logos for Enimga2."
MAINTAINER = "DimitarCC"
HOMEPAGE = "https://github.com/DimitarCC/e2-boxlogos"
require conf/license/license-gplv2.inc
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "enigma-info"

ALLOW_EMPTY:${PN} = "1"

inherit gitpkgv python3-compileall

PV = "1.0+gitr"
PKGV = "1.0+gitr${GITPKGV}"

do_configure[nostamp] = "1"

SRC_URI = "git://github.com/DimitarCC/e2-boxlogos.git;protocol=https;branch=main"

FILES:${PN} = "${datadir}/enigma2/logos/ ${libdir}/enigma2/python/Components/Renderer/"

do_install() {
	install -d ${D}${datadir}/enigma2/logos

	# get OE-A compatible build info
	INFOFILE=${DEPLOY_DIR_IMAGE}/../../enigma-info/${MACHINE}.txt
	MACHINE_BRAND=$( cat $INFOFILE | grep "displaybrand=" | cut -d "=" -f 2- )
	DISTRO_NAME=$( cat $INFOFILE | grep "distro=" | cut -d "=" -f 2- )

	if [ -f "${S}/brand/${MACHINE_BRAND}.svg" ] ; then
		install -m 0644 "${S}/brand/${MACHINE_BRAND}.svg" ${D}${datadir}/enigma2/logos/brandlogo.svg
	fi

	if [ -f "${S}/brand/${MACHINE_BRAND}.png" ] ; then
		install -m 0644 "${S}/brand/${MACHINE_BRAND}.png" ${D}${datadir}/enigma2/logos/brandlogo.png
	fi

	if [ -f "${S}/brand/${MACHINE_BRAND}_large.png" ] ; then
		install -m 0644 "${S}/brand/${MACHINE_BRAND}_large.png" ${D}${datadir}/enigma2/logos/brandlogo_large.png
	fi

	if [ -f "${S}/brand/${MACHINE_BRAND}_medium.png" ] ; then
		install -m 0644 "${S}/brand/${MACHINE_BRAND}_medium.png" ${D}${datadir}/enigma2/logos/brandlogo_medium.png
	fi

	if [ -f "${S}/distro/${DISTRO_NAME}.svg" ] ; then
		install -m 0644 "${S}/distro/${DISTRO_NAME}.svg" ${D}${datadir}/enigma2/logos/distrologo.svg
	fi

	if [ -f "${S}/distro/${DISTRO_NAME}.png" ] ; then
		install -m 0644 "${S}/distro/${DISTRO_NAME}.png" ${D}${datadir}/enigma2/logos/distrologo.png
	fi

	if [ -f "${S}/distro/${DISTRO_NAME}_large.png" ] ; then
		install -m 0644 "${S}/distro/${DISTRO_NAME}_large.png" ${D}${datadir}/enigma2/logos/distrologo_large.png
	fi

	if [ -f "${S}/distro/${DISTRO_NAME}_medium.png" ] ; then
		install -m 0644 "${S}/distro/${DISTRO_NAME}_medium.png" ${D}${datadir}/enigma2/logos/distrologo_medium.svg
	fi

	if [ -f "${S}/box/${MACHINE}.svg" ] ; then
		install -m 0644 "${S}/box/${MACHINE}.svg" ${D}${datadir}/enigma2/logos/boxlogo.svg
	fi
	if [ -f "${S}/box/${MACHINE}.png" ] ; then
		install -m 0644 "${S}/box/${MACHINE}.png" ${D}${datadir}/enigma2/logos/boxlogo.png
	fi
	if [ -f "${S}/box/${MACHINE}_large.png" ] ; then
		install -m 0644 "${S}/box/${MACHINE}_large.png" ${D}${datadir}/enigma2/logos/boxlogo_large.png
	fi
	if [ -f "${S}/box/${MACHINE}_medium.png" ] ; then
		install -m 0644 "${S}/box/${MACHINE}_medium.png" ${D}${datadir}/enigma2/logos/boxlogo_medium.png
	fi
	if [ "${MACHINE}" = "h10" ]; then
		cp ${S}/box/zgemmah10*.svg ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/zgemmah10*.png ${D}${datadir}/enigma2/logos/ || true
	elif [ "${MACHINE}" = "h11" ]; then
		cp ${S}/box/zgemmah11*.svg ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/zgemmah11*.png ${D}${datadir}/enigma2/logos/ || true
	elif [ "${MACHINE}" = "h3" ]; then
		cp ${S}/box/zgemmah3*.svg ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/zgemmah3*.png ${D}${datadir}/enigma2/logos/ || true
	elif [ "${MACHINE}" = "h5" ]; then
		cp ${S}/box/zgemmah5*.svg ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/zgemmah5*.png ${D}${datadir}/enigma2/logos/ || true
	elif [ "${MACHINE}" = "h9" -o "${MACHINE}" = "h9se" ]; then
		cp ${S}/box/zgemmah9*.svg  ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/zgemmah9*.png  ${D}${datadir}/enigma2/logos/ || true
	elif [ "${MACHINE}" = "sf8008" ]; then
		cp ${S}/box/sf8008*.svg ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/sf8008*.png ${D}${datadir}/enigma2/logos/ || true
	elif [ "${MACHINE}" = "sfx6008" ]; then
		cp ${S}/box/sfx60*.svg ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/sfx60*.png ${D}${datadir}/enigma2/logos/ || true
	elif [ "${MACHINE}" = "ustym4kpro" ]; then
		cp ${S}/box/ustym4k*.svg ${D}${datadir}/enigma2/logos/ || true
		cp ${S}/box/ustym4k*.png ${D}${datadir}/enigma2/logos/ || true
	fi
	chmod -f 644 "${D}${datadir}/enigma2/logos/*.svg" || true
	chmod -f 644 "${D}${datadir}/enigma2/logos/*.png" || true

    install -d ${D}${libdir}/enigma2/python/Components/Renderer
    cp -r ${S}/Renderer/* ${D}${libdir}/enigma2/python/Components/Renderer
    python3 -m compileall -o2 -b ${D}${libdir}/enigma2/python/Components/Renderer
}

pkg_postinst_ontarget:${PN} () {
#!/bin/sh
set -e

if [ -n "$D" ]; then
    $INTERCEPT_DIR/postinst_intercept delay_to_first_boot enigma2-boxlogos mlprefix=
    exit 0
fi

#
# enigma.info file, bail out if the file does not exist
#
INFOFILE=/usr/lib/enigma.info
if [ ! -f $INFOFILE ]; then
    exit 0
fi

# get the machine brand name for this image
MACHINEBUILD=`grep "machinebuild=" $INFOFILE | cut -d '=' -f 2`

# move the image if it exists
[ -f "${datadir}/enigma2/logos/$MACHINEBUILD.svg" ] && mv "${datadir}/enigma2/logos/$MACHINEBUILD.svg" "${datadir}/enigma2/logos/boxlogo.svg"
[ -f "${datadir}/enigma2/logos/$MACHINEBUILD.png" ] && mv "${datadir}/enigma2/logos/$MACHINEBUILD.png" "${datadir}/enigma2/logos/boxlogo.png"
[ -f "${datadir}/enigma2/logos/$MACHINEBUILD_large.png" ] && mv "${datadir}/enigma2/logos/$MACHINEBUILD_large.png" "${datadir}/enigma2/logos/boxlogo_large.png"
[ -f "${datadir}/enigma2/logos/$MACHINEBUILD_medium.png" ] && mv "${datadir}/enigma2/logos/$MACHINEBUILD_medium.png" "${datadir}/enigma2/logos/boxlogo_medium.png"

# remove all other box images
rm -f ${datadir}/enigma2/logos/zgemmah10*.svg
rm -f ${datadir}/enigma2/logos/zgemmah11*.svg
rm -f ${datadir}/enigma2/logos/zgemmah3*.svg
rm -f ${datadir}/enigma2/logos/zgemmah9*.svg
rm -f ${datadir}/enigma2/logos/sf8008*.svg
rm -f ${datadir}/enigma2/logos/sfx60*.svg
rm -f ${datadir}/enigma2/logos/ustym4k*.svg
rm -f ${datadir}/enigma2/logos/zgemmah10*.png
rm -f ${datadir}/enigma2/logos/zgemmah11*.png
rm -f ${datadir}/enigma2/logos/zgemmah3*.png
rm -f ${datadir}/enigma2/logos/zgemmah9*.png
rm -f ${datadir}/enigma2/logos/sf8008*.png
rm -f ${datadir}/enigma2/logos/sfx60*.png
rm -f ${datadir}/enigma2/logos/ustym4k*.png

exit 0
}
