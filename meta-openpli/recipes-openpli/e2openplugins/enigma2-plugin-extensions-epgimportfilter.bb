MODULE = "EPGImportFilter"
DESCRIPTION = "EPGImport Filter"

RDEPENDS:${PN} = "\
	python3-difflib \
	python3-shell \
	"

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins.inc
require openplugins-distutils.inc

BRANCH = "master"
