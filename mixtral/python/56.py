import base64
import binascii
import hashlib
import hmac

def pbkdf2(password, salt, iterations, key_length):
    salt_bytes = bytes.fromhex(salt)
    password_bytes = password.encode('utf-8')
    key = hashlib.pbkdf2_hmac('sha256', password_bytes, salt_bytes, iterations, key_length)
    return base64.urlsafe_b64encode(key)

hash = pbkdf2('test', 'f7fe4d511bcd33321747a778dd21097f4c0ff98f1e0eba39', 1000, 24)
hex_hash = binascii.b2a_hex(base64.urlsafe_b64decode(hash)).decode()
print(hex_hash)