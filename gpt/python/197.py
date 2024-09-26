
import hashlib
from base64 import b64encode
from Crypto.Cipher import AES
import os

def derive_key_and_iv(password, salt, key_length, iv_length):
    d = d_i = b''
    while len(d) < key_length + iv_length:
        d_i = hashlib.md5(d_i + password.encode() + salt).digest()
        d += d_i
    return d[:key_length], d[key_length:key_length+iv
