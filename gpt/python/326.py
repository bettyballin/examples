
import hashlib

def sha512_hash(password, salt):
    return hashlib.sha512((salt + password).encode
