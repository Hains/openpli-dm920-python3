DESCRIPTION = "Frequency lists"
MAINTAINER = "PLi team"

require conf/license/openpli-gplv2.inc
inherit allarch gitpkgv

PV = "2+git${SRCPV}"
PKGV = "2+git${GITPKGV}"
PR = "3"

SRC_URI = "git://github.com/OpenPLi/tuxbox-xml.git;protocol=git"
S = "${WORKDIR}/git/xml"
FILES_${PN} = "${sysconfdir}/tuxbox/* ${prefix}/* ${localstatedir}/*"

do_compile() {
	true
}

do_install() {
	install -m 0755 -d "${D}${sysconfdir}"
	install -m 0755 -d "${D}${sysconfdir}/tuxbox"
	install -m 0755 -d "${D}${sysconfdir}/tuxbox/scce"
	install -m 0755 -d "${D}${prefix}/keys"
	install -m 0755 -d "${D}${bindir}"
	install -m 0755 -d "${D}${localstatedir}"

	install -m 0644 "${S}"/*.xml "${D}${sysconfdir}/tuxbox"

	if [ ! -d "${D}${localstatedir}/scce" ]; then ln -s "${sysconfdir}/tuxbox/scce" "${D}${localstatedir}/"; fi
	if [ ! -d "${D}${localstatedir}/keys" ]; then ln -s "${prefix}/keys"            "${D}${localstatedir}/"; fi
	if [ ! -d "${D}${localstatedir}/bin" ];  then ln -s "${bindir}"                 "${D}${localstatedir}/"; fi
	if [ ! -d "${D}${localstatedir}/etc" ];  then ln -s "${sysconfdir}"             "${D}${localstatedir}/"; fi
}
