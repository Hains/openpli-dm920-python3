# This is pkg_postinst_${PN}_append for softcams which are included in image.

# If no cam selected yet, install and start this cam (and don't start it on the build host).
pkg_postinst_ontarget_${PN}_append () {
	if [ ! -e "${CAMLINK}" ] || [ "/etc/init.d/softcam.None" = "`readlink -f ${CAMLINK}`" ]
	then
		rm -f "${CAMLINK}"
		ln -s "softcam.${CAMNAME}" "${CAMLINK}"
		echo "Switching default softcam to ${CAMNAME}"
	fi
	if [ "${CAMPATH}" = "`readlink -f ${CAMLINK}`" ]
	then
		echo "Softcam is selected as default, (re)starting ${CAMNAME}"
		${CAMPATH} restart
	fi
}
