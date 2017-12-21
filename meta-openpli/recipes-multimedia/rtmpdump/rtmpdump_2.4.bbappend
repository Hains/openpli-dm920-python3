SRCREV = "fa8646daeb19dfd12c181f7d19de708d623704c0"

PROVIDES =+ " librtmp librtmp1"

SRC_URI = " \
	git://git.ffmpeg.org/rtmpdump \
	file://ksv.patch \
	file://fix-racing-build-issue.patch \
	file://iptvplayer_release.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
