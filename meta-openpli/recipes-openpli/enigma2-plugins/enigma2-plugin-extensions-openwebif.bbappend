PACKAGE_ARCH = "${MACHINE_ARCH}"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://get-rid-of-orgdream.patch \
"

python do_cleanup () {

    import os

    pluginpath = "%s%s" % (d.getVar('D', True), d.getVar('PLUGINPATH', True))
    images = "%s/public/images/" % pluginpath
    keymaps = "%s/public/static/" % pluginpath

    target_box = 'dm8000.png'
    target_remote = 'dmm1.png'
    target_keymap = 'dmm1.html'
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

addtask do_cleanup after do_install before do_package

PACKAGES =+ "${PN}-vxg"
DESCRIPTION_${PN}-vxg = "Adds Google Chrome support to OpenWebif's WebTV"
FILES_${PN}-vxg = "/usr/lib/enigma2/python/Plugins/Extensions/OpenWebif/public/vxg"
RDEPENDS_${PN}-vxg =+ "${PN}"
