# This is pkg_postinst_${PN}_append for softcams which are included in image.


# Don't start it on the build host.
pkg_postinst_${PN}_append () {
	if [ "${CAMPATH}" = "`readlink -f ${CAMLINK}`" ]
	then
		echo "Softcam is selected as default, (re)starting ${CAMNAME}"
		${CAMPATH} restart
	fi
}
