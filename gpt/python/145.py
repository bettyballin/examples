
from Crypto.Cipher import AES
from Crypto import Random
import hashlib

# Since Node.js crypto.createCipher uses OpenSSL's EVP_BytesToKey method
# which derives key and IV from the password provided, we need to replicate that.
def derive_key_and_iv(password, salt, key_length, iv_length):
    d = d_i = ''
    while len(d) < key_length + iv_length:
        d_i = hashlib.md5(d_i + password + salt).digest()
        d += d_i
    return d[:key_length], d[key_length:key_length+iv_length]

def
