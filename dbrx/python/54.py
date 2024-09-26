import base64
import hashlib

def pbkdf2_sha1(password: str, salt: bytes, iterations: int) -> bytes:
    return hashlib.pbkdf2_hmac('sha1', password.encode(), salt, iterations)

password = 'test'
salt = b'f7fe4d511bcd33321747a778dd21097f4c0ff98f1e0eba39'
iterations = 1000
key_size = 24

hash_value = pbkdf2_sha1(password, salt, iterations)[:key_size]
base64_hash = base64.b16encode(hash_value).decode().lower()

print(f'{iterations}:{salt.decode()}:{base64_hash}')