DESCRIPTION = "pyLoad is a fast, lightweight and full featured download manager for many One-Click-Hoster"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.MD;md5=d4333f07cbfa8fe036e90820f556b2ad"
HOMEPAGE = "http://pyload.org/"
RDEPENDS:${PN} = "\
  python3-compression \
  python3-db \
  python3-email \
  python3-html \
  python3-imaging \
  python3-numbers \
  python3-pprint \
  python3-pycrypto \
  python3-pycurl \
  python3-sqlite3 \
  python3-terminal \
  python3-unixadmin \
  python3-xmlrpc \
"
RRECOMMENDS:${PN} = "unrar"

PV = "0.4.20"

inherit update-rc.d

SRCREV = "1f29cd14d4c3d90d3249d20165a21c2b04ffed26"
SRC_URI = "git://github.com/pyload/pyload.git;branch=stable \
	file://pyload.init \
	file://pyload.tar.gz.defaults"

S = "${WORKDIR}/git"

FILES:${PN} = "/usr/pyload/* /etc/*"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults 60 "

do_compile() {
	python3 -m compileall ${S}
}

do_install() {
	install -d ${D}/etc/init.d
	install -d ${D}/usr/pyload

	cp -r ${S}/icons ${D}/usr/pyload
	cp -r ${S}/locale ${D}/usr/pyload
	cp -r ${S}/module ${D}/usr/pyload
	cp -r ${S}/scripts ${D}/usr/pyload
	install -m 755 ${S}/pyLoadCli.py ${D}/usr/pyload
	install -m 755 ${S}/pyLoadCore.py ${D}/usr/pyload
	install -m 755 ${S}/systemCheck.py ${D}/usr/pyload
	cp ${WORKDIR}/pyload.tar.gz.defaults ${D}/usr/pyload/pyload-defaults.tar.gz
	
	install -m 0755 ${WORKDIR}/pyload.init ${D}/etc/init.d/pyload
}

