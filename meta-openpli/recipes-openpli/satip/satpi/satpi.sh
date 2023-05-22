#!/bin/sh
#
# start/stop satpi server.

if [ -e /etc/default/satpi ]; then
	. /etc/default/satpi
fi

if ! [ -x /usr/bin/satpi ]; then
	exit 0
fi

case "$1" in
	start)
	echo -n "Starting satpi:"
	start-stop-daemon -S -x /usr/bin/satpi -p /var/lock/SatPI.lock -- --http-path /usr/share/satpi/web $SATPI_OPTS > /dev/null
	echo "."
	;;
    stop)
	echo -n "Stopping satpi:"
	start-stop-daemon -K -x /usr/bin/satpi -p /var/lock/SatPI.lock > /dev/null
	echo "."
	;;
    restart)
	echo -n "Restarting satpi:"
	echo
	$0 stop
	$0 start
	# killall -HUP inetd
	#echo "."
	;;
	*)
	echo "Usage: /etc/init.d/satpi {start|stop|restart}"
	exit 1
	;;
esac

exit 0

