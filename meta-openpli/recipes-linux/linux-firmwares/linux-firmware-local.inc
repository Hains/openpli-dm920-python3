inherit allarch

LICENSE = "LicenseRef-LICENSE-CLOSED"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/meta-openpli/licenses/LICENSE-CLOSED;md5=2d5b03b35d4612637d67724b35738dd7"

PACKAGES = "${PN}"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
FILES:${PN} += "${base_libdir}/firmware"
