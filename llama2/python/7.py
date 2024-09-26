import hashlib
from Crypto.Cipher import AES

def encrypt(num, secret_key):
    # Use AES-128 CTR mode for encryption
    key = hashlib.sha256(secret_key.encode()).digest()
    iv = b'0001000000000000000000000000000'
    cipher = AES.new(key, AES.MODE_CTR, iv)
    encrypt_data = num.to_bytes(32, byteorder='big')
    encrypted_data = cipher.encrypt(encrypt_data)
    return int.from_bytes(encrypted_data, byteorder='big')

def decrypt(num, secret_key):
    # Use AES-128 CTR mode for decryption
    key = hashlib.sha256(secret_key.encode()).digest()
    iv = b'00010000000000000000000000000000'
    cipher = AES.new(key, AES.MODE_CTR, iv)
    encrypted_data = num.to_bytes(32, byteorder='big')
    decrypted_data = cipher.decrypt(encrypted_data)
    return int.from_bytes(decrypted_data, byteorder='big')