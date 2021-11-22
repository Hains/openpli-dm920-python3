inherit image_types

IMAGEDIR = "${MACHINE}"
PDATE = "${@time.strftime('%Y%m%d',time.gmtime())}"
IMAGEVERSION := "OPENPLI-${DISTRO_VERSION}-${MACHINE}-${PDATE}"

IMAGE_CMD:tar = "tar --sort=name --numeric-owner -cf ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.tar -C ${IMAGE_ROOTFS} . || [ $? -eq 1 ]"

IMAGE_CMD:tar:prepend = " \
    mkdir -p ${IMAGE_ROOTFS}/tmp; \
    "

CONVERSION_CMD:bz2 = " \
    rm -f ${DEPLOY_DIR_IMAGE}/*.zip; \
    bzip2 -f -k ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.tar; \
    mkdir -p ${IMAGEDIR}; \
    cp ${DEPLOY_DIR_IMAGE}/zImage ${IMAGEDIR}/${KERNEL_FILE}; \
    echo "${IMAGEVERSION}" > ${IMAGEDIR}/imageversion; \
    cp ${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.tar.bz2 ${IMAGEDIR}/rootfs.tar.bz2; \
    zip openpli-${DISTRO_VERSION}_${MACHINE}_${PDATE}.zip ${IMAGEDIR}/*; \
    rm -f *.manifest; \
    rm -rf ${IMAGEDIR}; \
    "
