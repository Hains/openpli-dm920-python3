DESCRIPTION = "Handle your EPG on enigma2 from various sources (opentv, xmltv, custom sources)"
HOMEPAGE = "https://github.com/oe-alliance/e2openplugin-CrossEPG"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "curl libxml2 python3 swig-native zlib"
RDEPENDS:${PN} += "enigma2 libcurl python3-core python3-compression xz"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv python3-dir python3native

SRCREV = "${AUTOREV}"
PV = "0.9.0+gitr"
PKGV = "0.9.0+gitr${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/oe-alliance/e2openplugin-CrossEPG.git;protocol=https;branch=dev \
           file://fix-build-with-fno-common.patch \
"

CFLAGS:append = " -std=gnu17 -I${STAGING_INCDIR}/libxml2/ -I${STAGING_INCDIR}/${PYTHON_DIR}/"

do_compile() {
    echo ${PV} > ${S}/VERSION
    oe_runmake SWIG="swig"
}

do_install() {
    oe_runmake 'D=${D}' install 'PYTHON_BASEVERSION=${PYTHON_BASEVERSION}'
    mv ${D}/usr/crossepg/libcrossepg.so ${D}${libdir}/
}

pkg_postrm:${PN}() {
    rm -fr ${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG > /dev/null 2>&1
}

python populate_packages:prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}

ALLOW_EMPTY:${PN} = "1"
FILES:${PN}:append = " /usr/crossepg ${libdir}/libcrossepg.so ${libdir}/${PYTHON_DIR}"
FILES:${PN}-src:append = " ${libdir}/${PYTHON_DIR}/crossepg.py"
FILES:${PN}-dbg:append = " /usr/crossepg/scripts/mhw2epgdownloader/.debug /usr/crossepg/scripts/mhw2epgdownloader/.debug"
FILES_SOLIBSDEV = ""

INSANE_SKIP:${PN} += "already-stripped ldflags"

do_package_qa[noexec] = "1"

CFLAGS += "-Wno-error=implicit-function-declaration"
