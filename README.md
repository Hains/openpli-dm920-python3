Build environment dreambox 8000 based on OpenPLi-homebuild(develop branch).

https://github.com/OpenPLi/openpli-oe-core/commits/develop

Thanks to OpenPLi to make this possible.

In comparison to OpenPLi this repository has:<br>
-Submodules bitbake, openembedded-core and meta-openembedded from master branch,<br>
&nbsp;with git snapshot of March 7th, 2019.<br>
-GCC 8.3.0<br>
-Glibc 2.29<br>
-GStreamer 1.15.2.1<br>
-Python 2.7.15<br>
-OpenSSL 1.1.1a<br>
-Dreambox kernel 3.2.102<br>
<br>
<br>
Feel free to send pull-request.

Tested on Ubuntu 18.10.
<br>
<br>
Dependencies:
```
sudo apt install autoconf automake bison bzip2 cvs diffstat flex g++ gawk gcc gettext git gzip help2man ncurses-bin lib32ncurses5-dev libc6-dev libtool texinfo patch perl pkg-config subversion tar texi2html zlib1g-dev chrpath libxml2-utils xsltproc libglib2.0-dev python-setuptools libc6-i386 genromfs guile-2.0-libs quilt
```
To build image:
```
git clone https://github.com/Hains/openpli-dm8000-oe-core.git

cd openpli-dm8000-oe-core

make image
```
When the build is finished, the image openpli-enigma2-homebuild-dm8000.nfi is in the:
```
build/tmp/deploy/images/dm8000/
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

sudo mkdir feeds;cd feeds;sudo mkdir openpli-homebuild;cd openpli-homebuild;

sudo ln -s /home/<your username>/openpli-dm8000-oe-core/build/tmp/deploy/ipk/dm8000 dm8000 

sudo ln -s /home/<your username>/openpli-dm8000-oe-core/build/tmp/deploy/ipk/all all

sudo ln -s /home/<your username>/openpli-dm8000-oe-core/build/tmp/deploy/ipk/mips32el mips32el
```
When it doesn't work, with FTP you can change the opkg config files of the box in etc/opkg/<br>
-all-feed.conf<br>
-dm8000-feed.conf<br>
-mips32el-feed.conf<br>

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
