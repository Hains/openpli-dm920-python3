OPENDREAMBOX_PROJECT ?= "${BPN}"

SRC_URI += "git://git.opendreambox.org/git/${OPENDREAMBOX_PROJECT}.git;branch=master"

inherit git-project
