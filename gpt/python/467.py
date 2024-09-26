
from Crypto.Protocol.KDF import PBKDF2
from Crypto.Hash import SHA1
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad

def enc(a):
    salt = "Ivan Medvedev".encode()
    key_iv = PBKDF2("lrvq/wyDf6tqhxvg8NuIDQ==", salt, dkLen=48, count=1000, hmac_hash_module=SHA1)
