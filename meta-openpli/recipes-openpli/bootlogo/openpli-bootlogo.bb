DESCRIPTION = "OpenPLi bootlogo"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "PLi team"
LICENSE = "CC-BY-NC-ND-4.0"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/CC-BY-NC-ND-4.0;md5=8009795292660aa9c8da059e5b1581c1"

RDEPENDS_${PN} += "showiframe"

PV = "4.0"

S = "${WORKDIR}/"

INITSCRIPT_NAME = "bootlogo"
INITSCRIPT_PARAMS = "start 21 S ."

inherit update-rc.d

# This needs a small explanation; when the machine has 'switchoff' support, it switches itself off, so we don't need switchoff.mvi...
SWITCHOFFMVI = "${@bb.utils.contains("MACHINE_FEATURES", "switchoff", "" , "switchoff.mvi", d)}"

SRC_URI = " \
	file://bootlogo.mvi \
	file://switchoff.mvi \
	file://bootlogo.sh \
	"

BINARY_VERSION = "1.3"

SRC_URI += "${@bb.utils.contains("MACHINE_FEATURES", "dreambox", "http://dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-bootlogo/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE_ARCH}.tar.bz2;name=${MACHINE_ARCH}" , "", d)}"

SRC_URI[dm8000.md5sum] = "1b63ac7e2bd5c0db0748606acc310d47"
SRC_URI[dm8000.sha256sum] = "91e4402190fe88cf394ae780141d968a1ebecd8db7b23c1f0ca3f4bfa9c9512a"

MVI = "${SWITCHOFFMVI} bootlogo.mvi"
MVISYMLINKS = "bootlogo_wait backdrop"

do_install() {
	install -d ${D}/boot
	install -d ${D}/usr/share
	for i in ${MVI}; do
		install -m 0755 ${S}/$i ${D}/usr/share/
		ln -sf /usr/share/$i ${D}/boot/$i
	done
	${@bb.utils.contains("MACHINE_FEATURES", "dreambox", "install -m 0755 ${S}/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE_ARCH}/bootlogo-${MACHINE_ARCH}.elf.gz ${D}/boot/; install -m 0755 ${S}/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE_ARCH}/bootlogo-${MACHINE_ARCH}.jpg ${D}/boot/", "", d)}
	for i in ${MVISYMLINKS}; do
		ln -sf /boot/bootlogo.mvi ${D}/boot/$i.mvi
		ln -sf /usr/share/bootlogo.mvi ${D}/usr/share/$i.mvi;
	done
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${S}/bootlogo.sh ${D}/${sysconfdir}/init.d/bootlogo
}

pkg_preinst_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		if mountpoint -q /boot
		then
			mount -o remount,rw,compr=none /boot
		else
			mount -t jffs2 -o rw,compr=none mtd:boot /boot
		fi
	fi
}

pkg_postinst_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}

pkg_prerm_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		if mountpoint -q /boot
		then
			mount -o remount,rw,compr=none /boot
		else
			mount -t jffs2 -o rw,compr=none mtd:boot /boot
		fi
	fi
}

pkg_postrm_${PN}_dreambox() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot /usr/share /etc/init.d"
