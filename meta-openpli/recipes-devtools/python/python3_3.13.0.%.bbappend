FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "3.13.1"

SRC_URI:remove = "file://fix-armv5.patch"

SRC_URI[sha256sum] = "9cf9427bee9e2242e3877dd0f6b641c1853ca461f39d6503ce260a59c80bf0d9"
