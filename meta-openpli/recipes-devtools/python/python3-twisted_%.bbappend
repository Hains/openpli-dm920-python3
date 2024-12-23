FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RDEPENDS:${PN}-core += "python3-service-identity"

SRC_URI:append = " file://0001-Revert-Remove-twisted.web.client.getPage-and-friends.patch"
