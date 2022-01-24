#!/bin/sh
# Licensed under GPLv2
# Load kernel modules for hotpluggable devices

if [ "$1x" == "stopx" ]
then
	exit 0
fi

# Probe all USB/HID/input modules so that drivers load automatically
grep -h '^usb:\|^input:\|^hid:' `find /sys/devices/ -name modalias` | while read m
do
	modprobe $m > /dev/null 2> /dev/null
done

exit 0
