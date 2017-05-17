Build environment dreambox 8000 based on OpenPLi-5(master-next branch).

Tested with Ubuntu 17.04.

Dependencies:

autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git-core gzip help2man
ncurses-bin lib32ncurses5-dev libc6-dev libtool texinfo patch perl pkg-config subversion 
tar texi2html zlib1g-dev chrpath libxml2-utils xsltproc libglib2.0-dev python-setuptools libc6-i386
genromfs guile-1.8-libs quilt

================================================================

To build image:


git clone https://github.com/Hains/openpli-dm8000-oe-core.git

cd openpli-dm8000-oe-core

MACHINE=dm8000 make image

================================================================

To build feed:


cd build

source env.source

bitbake -k openpli-enigma2-feed
