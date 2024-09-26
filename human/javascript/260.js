const BCRYPT_ECCKEY_BLOB = {
  dwMagic: 0x3141534E,
  cbKey: 32,
  X: new Uint8Array(32), // Big-endian.
  Y: new Uint8Array(32) // Big-endian.
};