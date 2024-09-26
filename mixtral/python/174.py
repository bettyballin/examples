#!/usr/bin/env python3

key = bytes.fromhex("2b7e151628aed2a6abf7158809cf4f3c")
IV  = bytes.fromhex("000102030405060708090a0b0c0d0e0f")
plaintext1 = bytes.fromhex('6bc1bee22e409f96e93d7e117393172a')
plaintext2 = bytes.fromhex("ae2d8a571e03ac9c9eb76fac45af8e51")
plaintext3 = bytes.fromhex('30c81c46a35ce411e5fbc1191a0a52ef')

print("Key:", key.hex())
print("IV:", IV.hex())
print("Plaintext 1:", plaintext1.hex())
print("Plaintext 2:", plaintext2.hex())
print("Plaintext 3:", plaintext3.hex())