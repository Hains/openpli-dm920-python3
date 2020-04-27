DESCRIPTION = "Control your receiver with a browser"
MAINTAINER = "Open Vision Developers"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python3-cheetah-native"

RDEPENDS_${PN} = "\
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

inherit gitpkgv distutils-openplugins gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/OpenWebif.git;protocol=git \
			file://fix-import-urllib.patch \
			file://fix-escape-as-html-escape-import.patch \
			file://replace-iteritems-by-items.patch \
"

S="${WORKDIR}/git"

do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif"
do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
	rm -rf ${D}${libdir}/enigma2/python/Plugins/*.egg-info
	rmdir -p --ignore-fail-on-non-empty ${D}${datadir} ${D}/${PYTHON_SITEPACKAGES_DIR} || true
}

FILES_${PN} = "${PLUGINPATH}"

python do_cleanup () {

    import os

    pluginpath = "%s%s" % (d.getVar('D', True), d.getVar('PLUGINPATH', True))
    images = "%s/public/images/" % pluginpath
    keymaps = "%s/public/static/" % pluginpath

    target_box = 'dm920.png'
    target_remote = 'dmm2.png'
    target_keymap = 'dmm2.html'
    exception = ''

    for root, dirs, files in os.walk(images + 'boxes', topdown=False):
        for name in files:
            if target_box != name and name != 'unknown.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(images + 'remotes', topdown=False):
        for name in files:
            if target_remote != name and name != 'ow_remote.png' and exception != name:
                os.remove(os.path.join(root, name))

    for root, dirs, files in os.walk(keymaps + 'remotes', topdown=False):
        for name in files:
            if target_keymap != name:
                os.remove(os.path.join(root, name))
}

addtask do_cleanup after do_populate_sysroot before do_package

RPROVIDES_${PN} =+ "${PN}-terminal"
DESCRIPTION_${PN}-terminal = "CLI for OpenWebif"
RDEPENDS_${PN}-terminal = "${PN} shellinabox"
RREPLACES_${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RCONFLICTS_${PN}-terminal = "enigma2-plugin-extensions-openwebif-terminal"
RPROVIDES_${PN}-terminal =+ "enigma2-plugin-extensions-openwebif-terminal"
