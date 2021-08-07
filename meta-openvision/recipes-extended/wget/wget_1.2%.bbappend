DEPENDS:remove = "gnutls"
DEPENDS:append = " openssl"
EXTRA_OECONF:remove = "--with-ssl=gnutls"
EXTRA_OECONF:append = " --with-ssl=openssl"
