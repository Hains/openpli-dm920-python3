SUMMARY = "Utilities needed to do transponder blindscan with dreambox dvb receivers"
LICENSE = "CLOSED"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_${PN} += "virtual/blindscan-dvbs virtual/blindscan-dvbc"

DEPENDS = "ncurses"
INSANE_SKIP_${PN} += "already-stripped"

PV = "${@bb.utils.contains("MACHINE", "dm800", "1.9", "1.12", d)}"

SRC_URI_dm800 += "http://dreamboxupdate.com/download/opendreambox/2.0.0/blindscan-utils/blindscan-utils_1.9_${DEFAULTTUNE}.tar.bz2;name=${DEFAULTTUNE}-denzil"
SRC_URI += "http://dreamboxupdate.com/download/opendreambox/2.2.0/blindscan-utils/${PV}/${DEFAULTTUNE}/2acb58192434f308bfed6879c51d5d6e/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-dora"
SRC_URI_dm900 += "http://dreamboxupdate.com/download/opendreambox/2.5.0/blindscan-utils/${PV}/${DEFAULTTUNE}/9e93783a6ac4611bb683d0b36fc44a87/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-krogoth"
SRC_URI_dm920 += "http://dreamboxupdate.com/download/opendreambox/2.5.0/blindscan-utils/${PV}/${DEFAULTTUNE}/9e93783a6ac4611bb683d0b36fc44a87/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-krogoth"
SRC_URI_dm520 += "http://dreamboxupdate.com/download/opendreambox/2.5.0/blindscan-utils/${PV}/${DEFAULTTUNE}/185cd9490723728f39953348e322f5c7/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-krogoth"
SRC_URI_dm820 += "http://dreamboxupdate.com/download/opendreambox/2.5.0/blindscan-utils/${PV}/${DEFAULTTUNE}/185cd9490723728f39953348e322f5c7/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-krogoth"
SRC_URI_dm7080 += "http://dreamboxupdate.com/download/opendreambox/2.5.0/blindscan-utils/${PV}/${DEFAULTTUNE}/185cd9490723728f39953348e322f5c7/blindscan-utils_${PV}_${DEFAULTTUNE}.tar.xz;name=${DEFAULTTUNE}-krogoth"

S = "${WORKDIR}/blindscan-utils_${PV}_${DEFAULTTUNE}"

PACKAGES = "${PN}"

SRC_URI[mips32el-nf-denzil.md5sum] = "143cb7253132af1ecd3aafa3679c6109"
SRC_URI[mips32el-nf-denzil.sha256sum] = "53d2760e3aa19eab6e19edabe8b9dd840c693ca30c43495904241e52fd40ea32"
SRC_URI[mips32el-dora.md5sum] = "2acb58192434f308bfed6879c51d5d6e"
SRC_URI[mips32el-dora.sha256sum] = "afe56c1d222c4d6d33509208116628c30f88916bda7a19e5c749dcbc914d6020"
SRC_URI[cortexa15hf-neon-vfpv4-krogoth.md5sum] = "9e93783a6ac4611bb683d0b36fc44a87"
SRC_URI[cortexa15hf-neon-vfpv4-krogoth.sha256sum] = "ff4de20d84cf6aef48270684cb78764f7ee9d13d92fab42217f378be06047d1f"
SRC_URI[mips32el-krogoth.md5sum] = "185cd9490723728f39953348e322f5c7"
SRC_URI[mips32el-krogoth.sha256sum] = "0458975ad8325355a5e9514fa4e3505f896298bdad7610718e090b640e3588c5"

do_install() {
    cp -r * ${D}
}

INHIBIT_PACKAGE_STRIP = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
