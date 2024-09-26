from binascii import hexlify, unhexlify
from itertools import cycle

def cipherkey(s, key):
    # Convert the string to binary
    s_bin = format(int(s, 16), '0{}b'.format((len(s) * 4)))

    # Extend the key if it's shorter than input
    bin_key = (format(int(key, 16), '08b') +
               "".join([bin(ord(_))[2:].zfill(8) for _ in cycle('13')).__iter__(len=max((len(s)*4, len(key))))))

    # XOR the input and key
    xor_result = ''.join(['0' if a == b else '1'
                          for (a, b) in zip(bin_key[:len(s_bin)], s_bin)]).zfill((len(s)*4))

    # Convert the result back to hex
    return int(''.join([xor_result[i: i+8]
                        for i in range(0, len(xor_result), 8)]), base=2)

def xor_cipher(s, key):
    n = cipherkey(s, key)

    # XOR the input and result
    out = hexlify((n ^ int.from_bytes(unhexlify(s), byteorder='big')).to_bytes(((len(bin(int('0x' + s))[2:])+7)//8), byteorder="big")).decode()

    return out

print(xor_cipher("636174", "13"))