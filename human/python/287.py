from binascii import hexlify, unhexlify

def main():
    key = unhexlify('2b7e151628aed2a6abf7158809cf4f3c')
    IV = unhexlify('000102030405060708090a0b0c0d0e0f')
    plaintext1 = unhexlify('6bc1bee22e409f96e93d7e117393172a')
    plaintext2 = unhexlify('ae2d8a571e03ac9c9eb76fac45af8e51')
    plaintext3 = unhexlify('30c81c46a35ce411e5fbc1191a0a52ef')

    print("Key:", hexlify(key))
    print("IV:", hexlify(IV))
    print("Plaintext 1:", hexlify(plaintext1))
    print("Plaintext 2:", hexlify(plaintext2))
    print("Plaintext 3:", hexlify(plaintext3))

if __name__ == "__main__":
    main()