DEPENDS:remove = "gnutls"
DEPENDS += "openssl"

EXTRA_OEMAKE = " \
	CC='${CC}' LD='${LD} ${STAGING_LIBDIR}' XCFLAGS='${CFLAGS}' XLDFLAGS='${LDFLAGS}' \
	SYS=posix INC=-I=/usr/include DESTDIR=${D} \
	prefix=${prefix} libdir=${libdir} incdir=${includedir}/librtmp bindir=${bindir} mandir=${mandir}"
