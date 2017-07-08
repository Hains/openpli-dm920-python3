Build environment dreambox 8000 based on OpenPLi-homebuild(develop branch).

https://github.com/OpenPLi/openpli-oe-core/commits/develop

Thanks to OpenPLi to make this possible.

In comparison to OpenPLi this repository has:<br>
-Submodules bitbake, openembedded-core and meta-openembedded taken from master branch(including gcc 7.1.0).<br>
-GStreamer 1.13.0<br>
-Dreambox kernel 3.2.90<br>

And some other things(debuglevel via GUI, proper driver date, splash logo, some skin changes etc), see enigma2.bb.

Feel free to send pull-request(dm8000 only!).

Tested with Ubuntu 17.04.
<br>
<br>
Dependencies:
```
sudo apt install autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git-core gzip help2man
ncurses-bin lib32ncurses5-dev libc6-dev libtool texinfo patch perl pkg-config subversion 
tar texi2html zlib1g-dev chrpath libxml2-utils xsltproc libglib2.0-dev python-setuptools libc6-i386
genromfs guile-1.8-libs quilt
```
To build image:
```
git clone https://github.com/Hains/openpli-dm8000-oe-core.git

cd openpli-dm8000-oe-core

MACHINE=dm8000 make image
```
At the end of the build, the image is in:

build/tmp/deploy/images/dm8000/openpli-enigma2-homebuild-dm8000.nfi

To build feed:
```
make feed
```

To update your box:

Install apache2:
```
sudo apt install apache2
```
Create symlinks to your build-environment:
```
cd /var/www/html

sudo mkdir feeds;cd feeds;sudo mkdir OpenPLi-homebuild;cd OpenPLi-homebuild;

sudo ln -s /home/<your longin name>/openpli-dm8000-oe-core/build/tmp/deploy/ipk/dm8000 dm8000 

sudo ln -s /home/<your longin name>/openpli-dm8000-oe-core/build/tmp/deploy/ipk/all all

sudo ln -s /home/<your longin name>/openpli-dm8000-oe-core/build/tmp/deploy/ipk/mips32el mips32el
```
When it doesn't work, with FTP you can change the opkg config files of the box in etc/opkg/<br>
-all-feed.conf<br>
-dm8000-feed.conf<br>
-mips32el-feed.conf<br>

With these files you can change e.g. hostname or ipadress and change path corresponding to the symlinks.
<br>
<br>
To update the image, jus run:
```
make image
```
or  
```
make feed                          //This update image and feed.
```
In case bitbake complains about MACHINE, you have to set 
```
MACHINE="dm8000"
```
in file /site.conf
<br>
<br>
To update build-environment, just run
```
make update                         //This also update all submodules.
```

For 3rd-party plugins, change link in:<br>
<br>
3rd-party-dm8000-feed.conf<br>
into:<br>
src/gz openpli-3rd-party-dm8000 http://downloads.pli-images.org/feeds/openpli-4/3rd-party-dm8000<br>

and in file:<br>
3rd-party-feed.conf<br>
change link into:<br>
src/gz openpli-3rd-party http://downloads.pli-images.org/feeds/openpli-4/3rd-party<br>
