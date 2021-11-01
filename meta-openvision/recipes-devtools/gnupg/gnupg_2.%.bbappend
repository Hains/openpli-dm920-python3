# split out gpgv from main package
RDEPENDS:${PN} = "gpgv"
PACKAGES =+ "gpgv"
FILES:gpgv = "${bindir}/gpgv*"
