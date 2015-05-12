SUMMARY = "Utilities for transponder & dvb-s blindscan"
SECTION = "base"
PRIORITY = "optional"
RDEPENDS_${PN} = "ncurses"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGES = "vuplus-blindscan-dvbs-utils vuplus-blindscan-dvbs-utils-dbg vuplus-blindscan-dvbc-utils vuplus-blindscan-dvbc-utils-dbg"

PROVIDES += "virtual/blindscan-dvbs virtual/blindscan-dvbc"
RPROVIDES_vuplus-blindscan-dvbs-utils += "virtual/blindscan-dvbs"
RPROVIDES_vuplus-blindscan-dvbc-utils += "virtual/blindscan-dvbc"

SRC_URI = "http://archive.vuplus.com/download/utils/vuplus-blindscan-utils-${PV}.tar.bz2"

PV = "3.7"
PR = "r1"

S = "${WORKDIR}/blindscan-utils"

FILES_vuplus-blindscan-dvbs-utils = "${bindir}/*_blindscan"
FILES_vuplus-blindscan-dvbc-utils = "${bindir}/tda1002x ${bindir}/ssh108* ${bindir}/tt3l10*"
FILES_vuplus-blindscan-dvbs-utils-dbg = "${bindir}/.debug/*_blindscan"
FILES_vuplus-blindscan-dvbc-utils-dbg = "${bindir}/.debug/tda1002x ${bindir}/.debug/ssh108*"

do_install() {
	install -d ${D}/${bindir}/
	for i in `find ${S} -type f -maxdepth 1`; do
		install -m 0755 $i ${D}/${bindir}/;
	done;
}

SRC_URI[md5sum] = "94873fcb634bf4f9519c39bceb4b5a6f"
SRC_URI[sha256sum] = "70c4dc7afba1f70bc7be51ad7a0785b99d12cf874b43a653deddcf86ef736c71"
