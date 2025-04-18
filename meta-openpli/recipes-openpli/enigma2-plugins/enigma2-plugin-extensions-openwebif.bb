DESCRIPTION = "Control your receiver with a browser"
MAINTAINER = "Open Vision Developers"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://README;md5=eb66cb719ed579d6523cf9c3e000d811"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python3-cheetah-native"

RDEPENDS:${PN} = "\
	aio-grab \
	python3-cheetah \
	python3-compression\
	python3-ipaddress\
	python3-json \
	python3-misc \
	python3-numbers \
	python3-pyopenssl \
	python3-shell \
	python3-unixadmin \
	"

inherit gitpkgv setuptools3_legacy gettext

PV = "git"
PKGV = "${GITPKGVTAG}"

SRC_URI = "git://github.com/oe-alliance/OpenWebif.git;protocol=https;branch=main \
		file://set-packages-explicit.patch \
		file://fix-module-imports.patch \
		file://get-rid-of-six.patch \
"

S = "${WORKDIR}/git"

do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif"
do_install:append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
	rm -rf ${D}${libdir}/enigma2/python/Plugins/*.egg-info
	rm -rf ${D}${libdir}/python${PYTHON_BASEVERSION}
}

FILES:${PN} = "${PLUGINPATH}"

RPROVIDES:${PN} =+ "${PN}-terminal"
DESCRIPTION:${PN}-terminal = "CLI for OpenWebif"
RDEPENDS:${PN}-terminal = "${PN} shellinabox"
RREPLACES:${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RCONFLICTS:${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RPROVIDES:${PN}-terminal =+ "enigma2-plugin-extensions-openwebif-terminal"
