SRCREV = "fa8646daeb19dfd12c181f7d19de708d623704c0"
SRC_URI = " \
    git://git.ffmpeg.org/rtmpdump \
    file://fix-racing-build-issue.patch"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
