SUMMARY = "Enigma2 Serien Recorder"
DESCRIPTION = "The SeriesRecorder plug-in makes it easier to record series by automatically creating timers for selected series."
SECTION = "extra"
MAINTAINER = "einfall, w22754, egn and MacDisein"
HOMEPAGE = "https://github.com/einfall/serienrecorder"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://license.txt;md5=43c18ca9896bbb1a0fdf78ab4d9902bd"

RDEPENDS:${PN} = "python3-sqlite3 python3-json python3-xmlrpc python3-email python3-requests"

SRC_URI = "\
	git://github.com/einfall/serienrecorder.git;protocol=https;branch=master \
	file://${BPN}-${PV}/setup.py \
	file://${BPN}-${PV}/setup_translate.py \
	"

inherit gitpkgv setuptools3-openplugins python3-compileall

PV = "1+git"
PKGV = "1+git${GITPKGV}"
PR = "r1"

