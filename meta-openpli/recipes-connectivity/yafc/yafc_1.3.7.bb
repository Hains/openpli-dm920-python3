SUMMARY = "Yafc is yet another ftp client (with some handy features)"
DESCRIPTION = "Yafc is a command-line Linux FTP client, with a bunch of useful \
        features which make it easier to use than ftp or sftp"

HOMEPAGE = "http://www.yafc-ftp.com"
BUGTRACKER = "https://github.com/sebastinas/yafc/issues/"
MAINTAINER = "Sebastian Ramacher"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=74f65085a4958dced34e7b33cdf95eaf"

DEPENDS = "krb5 libbsd libssh openssl readline"

SRC_URI = "git://github.com/sebastinas/yafc.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit gitpkgv autotools-brokensep pkgconfig
PV = "1.3.7+git${SRCPV}"
PKGV = "1.3.7+git${GITPKGV}"
