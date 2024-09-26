import os
import base64
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.primitives.ciphers.aead import ChaCha20Poly1305

def encrypt_file(password, salt, nonce, original):
    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=5
    )

    key = base64.urlsafe_b64encode(kdf.derive(password))

    cipher = ChaCha20Poly1305(key)

    encrypted = cipher.encrypt(nonce, original, salt)

    return (encrypted, nonce)

def decrypt_file(ciphertext, password, salt, stored_nonce):
    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=5
    )

    key = base64.urlsafe_b64encode(kdf.derive(password))

    cipher = ChaCha20Poly1305(key)

    decrypted = cipher.decrypt(stored_nonce, ciphertext, salt)

    return decrypted

# Encryption
original = b'Hello World!'
salt = os.urandom(16)
password = 'Password@123'.encode()
nonce = os.urandom(12)

encrypted, stored_nonce = encrypt_file(password, salt, nonce, original)

print('Encrypted: ', base64.urlsafe_b64encode(encrypted))
print('Nonce: ', base64.urlsafe_b64encode(stored_nonce))

# Decryption
decrypted = decrypt_file(encrypted, password, salt, stored_nonce)

print('Decrypted: ', decrypted.decode())