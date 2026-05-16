inherit python3-dir

RDEPENDS:{PN}-src = "${PN}"

# some txt files which should go into -doc
FILES:${PN}-doc += " \
    ${PYTHON_SITEPACKAGES_DIR}/*-info \
    ${PYTHON_SITEPACKAGES_DIR}/*/*-info \
    ${PYTHON_SITEPACKAGES_DIR}/*-INFO \
    ${PYTHON_SITEPACKAGES_DIR}/*/*-INFO \
    ${PYTHON_SITEPACKAGES_DIR}/*-safe \
    ${PYTHON_SITEPACKAGES_DIR}/*/*-safe \
    ${PYTHON_SITEPACKAGES_DIR}/*.txt \
    ${PYTHON_SITEPACKAGES_DIR}/*/*.txt \
    ${PYTHON_SITEPACKAGES_DIR}/*/*/*.txt \
    ${PYTHON_SITEPACKAGES_DIR}/doc \
    ${PYTHON_SITEPACKAGES_DIR}/*/doc \
    ${PYTHON_SITEPACKAGES_DIR}/LICENSE \
    ${PYTHON_SITEPACKAGES_DIR}/README \
    "
