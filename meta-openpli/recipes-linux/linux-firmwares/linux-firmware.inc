inherit gitpkgv

PV = "1.1+git"
PKGV = "1.1+git${GITPKGV}"

SRC_URI = "git://github.com/BjornLee/linux-firmware.git;protocol=https;branch=master"

require linux-firmware-local.inc
