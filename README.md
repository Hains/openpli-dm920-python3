Experimental build environment for dreambox 920 based on Open Vision with Python 3.
Work in progeress, so not suitable for daily use!

https://github.com/OpenVisionE2/openvision-oe

-Submodules bitbake, openembedded-core and meta-openembedded from master branch,<br>
&nbsp;with git snapshot of August 1st, 2020.<br>
-GCC 10.1.0<br>
-Glibc 2.31<br>
-GStreamer 1.17.2.1<br>
-Python 3.8.5<br>
-OpenSSL 1.1.1g<br>
-Busybox 1.32.0<br>
and more.<br>
<br>
<br>
Feel free to send pull-request.

Tested wit Ubuntu 20.04.
<br>
<br>
Dependencies:
```
sudo apt install autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git git-lfs gzip help2man ncurses-bin lib32ncurses5-dev libc6-dev libtool texinfo patch perl pkg-config subversion tar texi2html zlib1g-dev chrpath libxml2-utils xsltproc libglib2.0-dev python-setuptools libc6-i386 genromfs guile-2.0-libs quilt
```
To build image:
```
git clone https://github.com/Hains/openvision-dm920-python3.git

cd openvision-dm920-python3

make image
```
When the build is finished, the image openvision-enigma2-10.1-dm920.rootfs.tar.bz2 is in the:
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

sudo mkdir feeds;cd feeds;sudo mkdir openvision-10.1;cd openvision-10.1;

sudo ln -s /home/<your username>/openvision-dm920-python3/build/tmp/deploy/ipk/dm920 dm920 

sudo ln -s /home/<your username>/openvision-dm920-python3/build/tmp/deploy/ipk/all all

sudo ln -s /home/<your username>/openvision-dm920-python3/build/tmp/deploy/ipk/cortexa15hf-neon-vfpv4 cortexa15hf-neon-vfpv4
```
Add hostname or ip address to the site.conf file (exist after make command), e.g. at the end of the file.
```
DISTRO_HOST = " <your ip address or hostname> "
```
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
