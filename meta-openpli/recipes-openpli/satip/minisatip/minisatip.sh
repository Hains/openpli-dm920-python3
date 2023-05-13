#!/bin/sh
#
# start/stop minisatip server.

if [ -e /etc/default/minisatip ]; then
	. /etc/default/minisatip
fi

if ! [ -x /usr/bin/minisatip ]; then
	exit 0
fi

case "$1" in
	start)
	echo -n "Starting minisatip:"
	start-stop-daemon -S -x /usr/bin/minisatip -p /var/run/minisatip.pid -- -R /usr/share/minisatip/html $MINISATIP_OPTS > /dev/null
	echo "."
	;;
	stop)
	echo -n "Stopping minisatip:"
	start-stop-daemon -K -x /usr/bin/minisatip -p /var/run/minisatip.pid > /dev/null
	echo "."
	;;
	restart)
	echo -n "Restarting minisatip:"
	echo
	$0 stop
	$0 start
	# killall -HUP inetd
	#echo "."
	;;
	*)
	echo "Usage: /etc/init.d/minisatip {start|stop|restart}"
	exit 1
	;;
esac

exit 0

