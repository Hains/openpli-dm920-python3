FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RDEPENDS:${PN}-core += "python3-service-identity"

SRC_URI:append = " file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch \
                   file://0002-fix-writing-after-channel-is-closed.patch \
"

include python3-package-split.inc
