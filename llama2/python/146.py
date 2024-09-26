from Crypto.Cipher import AES
from Crypto import Random
import hashlib
import base64

# Use PBKDF2 to derive a secure key from the password
password = b'lazydog'
salt = b'salt'
iterations = 1000
key_length = 32  # 256 bits for AES-256
key = hashlib.pbkdf2_hmac('sha256', password, salt, iterations, key_length)

# Use a fixed IV for encryption and decryption
iv = b'\x00' * 16  # 128 bits

# Encrypt the message
cipher = AES.new(key, AES.MODE_CBC, iv)
message = b'Hello World!'
encrypted_message = cipher.encrypt(message)

print("Encrypted message:", encrypted_message)

# Decrypt the message
decrypted_message = cipher.decrypt(encrypted_message)

print("Decrypted message:", decrypted_message.decode('utf-8'))