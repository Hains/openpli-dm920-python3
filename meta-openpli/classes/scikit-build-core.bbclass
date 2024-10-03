DEPENDS += "scikit-build-core-native ninja-native"

inherit python_pep517 python3native python3-dir

# Copied from setuptools-base bbclass

DEPENDS:append:class-target = " python3-native python3"
DEPENDS:append:class-nativesdk = " python3-native python3"
RDEPENDS:${PN}:append:class-target = " python3-core"

export STAGING_INCDIR
export STAGING_LIBDIR

# LDSHARED is the ld *command* used to create shared library
export LDSHARED  = "${CCLD} -shared"
# LDXXSHARED is the ld *command* used to create shared library of C++
# objects
export LDCXXSHARED  = "${CXX} -shared"
# CCSHARED are the C *flags* used to create objects to go into a shared
# library (module)
export CCSHARED  = "-fPIC -DPIC"
# LINKFORSHARED are the flags passed to the $(CC) command that links
# the python executable
export LINKFORSHARED = "${SECURITY_CFLAGS} -Xlinker -export-dynamic"

FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}"
FILES:${PN}-staticdev += "${PYTHON_SITEPACKAGES_DIR}/*.a"
FILES:${PN}-dev += "${PYTHON_SITEPACKAGES_DIR}/*.la"


# Copied from python_hatchling bbclass

# delete nested, empty directories from the python site-packages path. Make
# sure that we remove the native ones for target builds as well
hatchling_rm_emptydirs:class-target () {
        find ${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages/* -depth -type d -empty -delete
        find ${STAGING_LIBDIR_NATIVE}/${PYTHON_DIR}/site-packages/* -depth -type d -empty -delete
}

hatchling_rm_emptydirs:class-native () {
        find ${STAGING_LIBDIR_NATIVE}/${PYTHON_DIR}/site-packages/* -depth -type d -empty -delete
}

# Define a default empty version of hatchling_rm_emptydirs to appease bitbake
hatchling_rm_emptydirs () {
        :
}

do_prepare_recipe_sysroot[postfuncs] += " hatchling_rm_emptydirs"

# Copied from python3target bbclass

EXTRA_PYTHON_DEPENDS ?= ""
EXTRA_PYTHON_DEPENDS:class-target = "python3"
DEPENDS:append = " ${EXTRA_PYTHON_DEPENDS}"

setup_target_config() {
        export _PYTHON_SYSCONFIGDATA_NAME="_sysconfigdata"
        export PYTHONPATH=${STAGING_LIBDIR}/python-sysconfigdata:$PYTHONPATH
        export PATH=${STAGING_EXECPREFIXDIR}/python-target-config/:$PATH
}

do_configure:prepend:class-target() {
        setup_target_config
}

#do_compile:prepend:class-target() {
#        setup_target_config
#}

do_install:prepend:class-target() {
        setup_target_config
}

do_configure:prepend:class-nativesdk() {
        setup_target_config
}

do_compile:prepend:class-nativesdk() {
        setup_target_config
}

do_install:prepend:class-nativesdk() {
        setup_target_config
}
