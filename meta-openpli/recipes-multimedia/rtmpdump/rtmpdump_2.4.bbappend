DEPENDS_remove = "openssl10"
DEPENDS += "openssl"

PROVIDES =+ " librtmp librtmp1"

SRC_URI = " \
	git://git.ffmpeg.org/rtmpdump \
	file://ksv.patch \
	file://fix-racing-build-issue.patch \
	file://fix-build-openssl110.patch \
	file://iptvplayer_release.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
