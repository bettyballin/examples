
from Crypto.Protocol.KDF import PBKDF2
from Crypto.Random import get_random_bytes
from Crypto.Cipher import AES
import base64

def derive_key_and_iv(password, salt, key_length, iv_length):
    d = d_i = b''
    while len(d) < key_length + iv_length:
        d_i = hashlib.md5(d_i + password + salt).digest()
        d += d_i
    return d[:key_length], d[key_length:key_length+iv_length]

def encrypt(data, password, key_length=32):
    bs = AES.block_size
    salt = get_random_bytes(bs - len('Salted__'))
    key, iv = derive_key_and_iv(password.encode(), salt, key_length, bs)
    cipher = AES.new(key, AES.MODE_CBC, iv)
    pad_len = bs - len(data
