SUMMARY = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
LICENSE = "CLOSED"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES:${PN} += "virtual/blindscan-dvbs virtual/blindscan-dvbc"

DEPENDS = "ncurses"
INSANE_SKIP:${PN} += "already-stripped"

PV = "1.12"

SRC_URI = "file://blindscan-utils_1.12_cortexa15hf-neon-vfpv4.tar.xz"

S = "${WORKDIR}/blindscan-utils_${PV}_${DEFAULTTUNE}"

PACKAGES = "${PN}"

SRC_URI[cortexa15hf-neon-vfpv4-krogoth.md5sum] = "9e93783a6ac4611bb683d0b36fc44a87"
SRC_URI[cortexa15hf-neon-vfpv4-krogoth.sha256sum] = "ff4de20d84cf6aef48270684cb78764f7ee9d13d92fab42217f378be06047d1f"

do_install() {
    cp -r * ${D}
}

INHIBIT_PACKAGE_STRIP = "1"
