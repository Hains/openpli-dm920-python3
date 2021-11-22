inherit image_types

IMAGEDIR = "${MACHINE}"
IMAGEVERSION := "OPENPLI-${DISTRO_VERSION}"

IMAGE_CMD:tar = "${IMAGE_CMD_TAR} --sort=name --format=gnu --numeric-owner -cf ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.tar -C ${IMAGE_ROOTFS} . || [ $? -eq 1 ]"

CONVERSION_CMD:bz2 = " \
    rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
    bzip2 -f -k ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.${type}; \
    mkdir -p ${IMAGEDIR}; \
    cp ${DEPLOY_DIR_IMAGE}/zImage ${IMAGEDIR}/${KERNEL_FILE}; \
    echo "${IMAGEVERSION}" > ${IMAGEDIR}/imageversion; \
    cp ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.tar.bz2 ${IMAGEDIR}/rootfs.tar.bz2; \
    zip openpli-${DISTRO_VERSION}_${MACHINE}.zip ${IMAGEDIR}/*; \
    rm -f *.manifest; \
    rm -rf ${IMAGEDIR}; \
    "
