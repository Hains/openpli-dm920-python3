FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "3.14.7"

SRC_URI[sha256sum] = "3b48dac8fb59f62eaa67ac83c1eb12bda1b7a08406dd286e252c11a66be27f81"

SRC_URI:append = " file://0001-gh-146207-Add-support-for-OpenSSL-4.0.0-alpha1-14621.patch"
SRC_URI:remove = "file://CVE-2026-11940.patch file://CVE-2026-11972.patch file://CVE-2026-4360.patch"
