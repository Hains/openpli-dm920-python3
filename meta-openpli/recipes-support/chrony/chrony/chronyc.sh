#!/bin/sh

DAEMON=/usr/sbin/chronyd
CLIENT=/usr/bin/chronyc
PIDFILE=/run/chrony/chronyd.pid

# check if the chrony daemon is running
if [ ! -f $PIDFILE ]; then
	exit 0
fi

PID=$(cat $PIDFILE)
if [ ! -d "/proc/${PID}" ]; then
	exit 0
fi

# check if we have the chrony client
if [ ! -x $CLIENT ]; then
	exit 0
fi

# tell chrony we should be online now
$CLIENT online
