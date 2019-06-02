SUMMARY = "Enigma2 Skin OctEtFHD"
MAINTAINER = "Open Vision Developers"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

require conf/license/license-gplv2.inc

inherit gitpkgv allarch

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI="git://github.com/OpenVisionE2/OctEtFHD-skin.git;protocol=git"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr"

do_package_qa[noexec] = "1"

do_install() {
    cp -r  --preserve=mode,links ${S}/usr ${D}/
}

do_install_append() {
    # remove unused .pyc files
    find ${D}/usr/lib/enigma2/python/ -name '*.pyc' -exec rm {} \;
}

do_compile_append() {
    python -O -m compileall ${S}
}

FILES_${PN}-src = "\
    /usr/lib/enigma2/python/*/*.py \
    /usr/lib/enigma2/python/*/*/*.py \
    "
