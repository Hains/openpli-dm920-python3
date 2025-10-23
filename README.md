Build environment for dreambox 920 with Python 3.<br><br>

-Submodules bitbake, openembedded-core and meta-openembedded from master branch,<br>
&nbsp;with git snapshot of October 18, 2025.<br>
-GCC 15.2.0<br>
-Glibc 2.42<br>
-GStreamer 1.26.7<br>
-Python 3.13.9<br>
-OpenSSL 3.5.4<br>
-Busybox 1.37.0<br>
and more.<br>
<br>
Tested with Ubuntu 25.10.
<br>
<br>
Dependencies:
```
sudo apt install -y autoconf automake bison bzip2 cvs default-jre diffstat flex g++ gawk gcc gettext git git-lfs gzip help2man make ncurses-bin lib32ncurses-dev libc6-dev libtool lz4 texinfo patch perl pkg-config subversion tar texi2html zlib1g-dev chrpath libxml2-utils xsltproc libglib2.0-dev python3-setuptools libc6-i386 genromfs guile-2.2-libs quilt zstd
```
<br>
Note for Ubuntu 24.04 LTS and newer.<br>

Due to new security features, add new /etc/sysctl.d/60-apparmor-namespace.conf file with the following contents:
```
kernel.apparmor_restrict_unprivileged_userns=0
```
See:
https://discourse.ubuntu.com/t/ubuntu-24-04-lts-noble-numbat-release-notes/39890
<br><br>
Note for Ubuntu 25.10.<br>
Use coreutils instead of rust-coreutils.<br>
https://bugzilla.yoctoproject.org/show_bug.cgi?id=16028<br>
https://discourse.ubuntu.com/t/migration-to-rust-coreutils-in-25-10/59708
<br>
Run:<br>
```
apt install coreutils-from-gnu coreutils-from-uutils- --allow-remove-essential
```
<br>To build image:
```
git clone https://github.com/Hains/openpli-dm920-python3.git

cd openpli-dm920-python3

make image
```
<br>When the build is finished, the openpli-enigma2-15.1-dm920.tar.bz2 image file is located in the:
```
build/tmp/deploy/images/dm920/
```
directory.

<br>To build feed:
```
make feed
```

<br>To update your box, install Apache2:
```
sudo apt install apache2
```
Create symlinks to your build-environment:
```
cd /var/www/html

sudo mkdir feeds;cd feeds;sudo mkdir openpli-python3;cd openpli-python3;

sudo ln -s /home/<your username>/openpli-dm920-python3/build/tmp/deploy/ipk/dm920 dm920 

sudo ln -s /home/<your username>/openpli-dm920-python3/build/tmp/deploy/ipk/all all

sudo ln -s /home/<your username>/openpli-dm920-python3/build/tmp/deploy/ipk/cortexa15hf-neon-vfpv4 cortexa15hf-neon-vfpv4
```
With recent Apache2, fix file permission problem with symlinks:
```
sudo chown -Rf <username> openpli-dm920-python3/build/tmp/deploy/ipk
```
<br>Add hostname or ip address to the site.conf file (file exist after make command), e.g. at the end of the file.
```
DISTRO_HOST = " <your ip address or hostname> "
```
<br>To update the image, run:
```
make image                         // update image only.
```
or  
```
make feed                          // update image and feed.
```

<br>To update build-environment including all submodules, run:
```
make update
```

==========================================================
