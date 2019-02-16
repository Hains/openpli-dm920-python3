# Commit 664ae3dc52fd7fc8c6f64e6cf5e70f97dedd332d in OE-core force-feeds
# bash into our system, which we definitely don't want to happen. This
# bbappend basically reverses that commit.
#
RDEPENDS_${PN}-client = "rpcbind"

# The startup script does a check that doesn't work, replace it. It's
# also overly complex, so simplified it too.
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://nfs-utils-Do-not-pass-CFLAGS-to-gcc-while-building.patch"

SRC_URI_remove = "file://0001-Don-t-build-tools-with-CC_FOR_BUILD.patch"

do_install_append () {
# the following are built by CC_FOR_BUILD
	rm -f ${D}${sbindir}/rpcdebug
	rm -f ${D}${sbindir}/rpcgen
	rm -f ${D}${sbindir}/locktest
}
