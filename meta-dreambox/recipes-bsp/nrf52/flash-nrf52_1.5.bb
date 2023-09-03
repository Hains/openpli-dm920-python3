SUMMARY = "Flasher for NRF52 based BLE Transceiver"

SRC_URI = "file://flash-nrf52_1.5_cortexa15hf-neon-vfpv4.tar.xz"

SRC_URI[sha256sum] = "e9f119af9bcadf4a74d91ed8ebccbf86bc423a2f38a32a46d7310cbea8fd8720"
SRC_URI[cortexa15hf-neon-vfpv4.md5sum] = "3649233eb10eaef04838f5021e0e4ca7"
SRC_URI[cortexa15hf-neon-vfpv4.sha256sum] = "e9f119af9bcadf4a74d91ed8ebccbf86bc423a2f38a32a46d7310cbea8fd8720"

inherit opendreambox-precompiled-binary
