SUMMARY = "Cloudflare Public DNS configuration"
HOMEPAGE = "https://cloudflare-dns.com/"
LICENSE = "LicenseRef-LICENSE-CLOSED"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/LICENSE-CLOSED;md5=2d5b03b35d4612637d67724b35738dd7"

SRC_URI = "file://resolv.conf"

S = "${UNPACKDIR}"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 644 ${UNPACKDIR}/resolv.conf ${D}${sysconfdir}/resolv.conf
}
