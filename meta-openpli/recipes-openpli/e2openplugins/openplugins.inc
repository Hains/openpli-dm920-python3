require conf/license/license-gplv2.inc

BRANCH ?= "python3"

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-${MODULE}.git;protocol=https;branch=${BRANCH}"

inherit pkgconfig gitpkgv

FILES:${PN}-dbg += "\
    /usr/lib/enigma2/python/Plugins/*/*/.debug \
    /usr/lib/enigma2/python/Plugins/*/*/*/.debug \
    /usr/lib/enigma2/python/Plugins/*/*/*/*/.debug \
    /usr/lib/enigma2/python/Plugins/*/*/*/*/*/.debug \
    /usr/lib/enigma2/python/Plugins/*/*/*/*/*/*/.debug \
    "

PV_MOD ?= "2.0+git"
PKGV_MOD ?= "2.0+git${GITPKGV}"

PV = "${PV_MOD}"
PKGV = "${PKGV_MOD}"
PR = "r0"

python populate_packages:prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
}
