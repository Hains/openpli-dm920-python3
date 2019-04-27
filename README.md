Build environment dreambox 920 based on OpenPLi-homebuild(develop branch).

https://github.com/OpenPLi/openpli-oe-core/commits/develop

Thanks to OpenPLi to make this possible.

In comparison to OpenPLi this repository has:<br>
-Submodules bitbake, openembedded-core and meta-openembedded from master branch,<br>
&nbsp;with git snapshot of April 21th, 2019.<br>
-GCC 8.3.0<br>
-Glibc 2.29<br>
-GStreamer 1.16.0<br>
-Python 2.7.16<br>
-OpenSSL 1.1.1b<br>
-Busybox 1.30.1<br>
and more.<br>
<br>
<br>
Feel free to send pull-request.

Tested on Ubuntu 19.04.
<br>
<br>
Dependencies:
```
sudo apt install autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git gzip help2man ncurses-bin lib32ncurses5-dev libc6-dev libtool texinfo patch perl pkg-config subversion tar texi2html zlib1g-dev chrpath libxml2-utils xsltproc libglib2.0-dev python-setuptools libc6-i386 genromfs guile-2.0-libs quilt
```
To build image:
```
git clone https://github.com/Hains/openvision-dm920-oe-core.git

cd openvision-dm920-oe-core

make image
```
When the build is finished, the image openpli-enigma2-homebuild-dm920.tar.bz2 is in the:
```
build/tmp/deploy/images/dm920/
```
directory.

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

sudo mkdir feeds;cd feeds;sudo mkdir openvision-homebuild;cd openvision-homebuild;

sudo ln -s /home/<your username>/openvision-dm920-oe-core/build/tmp/deploy/ipk/dm920 dm920 

sudo ln -s /home/<your username>/openvision-dm920-oe-core/build/tmp/deploy/ipk/all all

sudo ln -s /home/<your username>/openvision-dm920-oe-core/build/tmp/deploy/ipk/cortexa15hf-neon-vfpv4 cortexa15hf-neon-vfpv4
```
When it doesn't work, with FTP you can change the opkg config files of the box in etc/opkg/<br>
-all-feed.conf<br>
-dm920-feed.conf<br>
-cortexa15hf-neon-vfpv4.conf<br>

With these files you can change e.g. hostname or ipadress and change path corresponding to the symlinks.
<br>
<br>
To update the image, run:
```
make image                         // update image only.
```
or  
```
make feed                          // update image and feed.
```

To update build-environment including all submodules, run:
```
make update
```

Notice: 
* Run 'make feed' twice before you update the box!

==========================================================
