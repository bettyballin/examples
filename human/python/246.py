from binascii import unhexlify

def xor_cipher(s, key):
    return hex(int(s, 16) ^ int(key, 16))[2:]

s = "your_string_here"
key = "your_key_here"

res = xor_cipher(s, key)
if len(res) % 2 == 1:
    res = "0{}".format(res)
print(unhexlify(res))