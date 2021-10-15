SUMMARY = "LCD4Linux plugin"
AUTHOR = "IHAD joergm6 <joergm6@www.i-have-a-dreambox.com>"
HOMEPAGE = "http://www.i-have-a-dreambox.com/wbb2/thread.php?threadid=165337"
MAINTAINER = "PLi team"
LICENSE = "NPOSL-3.0"
LIC_FILES_CHKSUM = "file://usr/lib/enigma2/python/Plugins/Extensions/LCD4linux/LICENSE;md5=a06300d1389bd32f84faeb97b6f6771f"

PKGVERSION = "5.0-r4"
PV = "${PKGVERSION}-${SRCPV}"
PKGV = "${PKGVERSION}-${GITPKGV}"

SRC_URI = "git://github.com/eriksl/enigma2-plugin-extensions-lcd4linux-ihad-source-copy.git"

RDEPENDS:${PN} += "\
	png-util \
	pydpflib \
	python3-codecs \
	python3-ctypes \
	python3-datetime \
	python3-email \
	python3-image \
	python3-imaging \
	python3-mutagen \
	python3-pyusb \
	python3-shell \
	python3-simplejson \
"

S = "${WORKDIR}/git"

inherit gitpkgv python3native

do_compile() {
	python -m compileall ${S}/usr/lib
}

do_install() {
	cp -r --preserve=mode,links "${S}/usr" "${D}"
	cp -r --preserve=mode,links "${S}/etc" "${D}"
}

FILES:${PN} = "\
	${libdir}/python3.10 \
	${libdir}/python3.10/site-packages \
	${libdir}/enigma2/python/Components/Renderer/PixmapLcd4linux.py* \
	${libdir}/enigma2/python/Plugins/Extensions/LCD4linux \
	${sysconfdir}/enigma2/lcd4config*"

CONFFILES:${PN} = "${sysconfdir}/enigma2/lcd4config"
