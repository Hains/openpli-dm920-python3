DESCRIPTION = "Autorecover settings and install packages at first boot from /media/*/backup"
PACKAGES = "${PN}"
MAINTAINER = "OpenPLi team"

require conf/license/openpli-gplv2.inc

PV = "2021042101"

SRC_URI = " file://convert-smbconf.py \
			file://settings-restore.sh \
"

# Need to tell bitbake that we have extra files installed
FILES:${PN} = " \
			${sysconfdir} \
			${base_bindir} \
"

S = "${WORKDIR}"

# Not inheriting from rc-update because the script commits suicide, which
# confuses the pkg scripts.
do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -d ${D}${base_bindir}
	# run-once initialization script
	install -m 644 ${S}/convert-smbconf.py ${D}${base_bindir}/convert-smbconf.py
	install -m 755 ${S}/settings-restore.sh ${D}${sysconfdir}/init.d/settings-restore.sh
	install -m 644 ${S}/convert-smbconf.py ${D}${base_bindir}/convert-smbconf.py
}

inherit allarch
