from binascii import hexlify, unhexlify

s = '636174'
key = '13'

def cipherkey(s, key):
    bin_key = format(int(key), '08b')
    bin_s = format(int(s, 16), '024b')
    return int(bin_key[:len(bin_s)] + bin_s[len(bin_key):], 2)

def xor_cipher(s, key):
    n = cipherkey(s, key)
    out = hex(n ^ int(s, 16))
    return unhexlify(out[2:])

print(xor_cipher(s, key))