require ../recipes-mediacenter/kodi/stb-kodi_${PV}.bb

PROVIDES += "virtual/kodi"
RPROVIDES:${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES:${PN} += "kodi"

EXTRA_OECONF += " \
    --with-platform=dreambox-cortexa15 \
    --with-ffmpeg=stb \
"
