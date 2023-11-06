inherit python3native

do_install:append:class-target () {
    python3 -m compileall ${D}
}
