import base64
import hashlib
import hmac
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend

fernet_key = base64.urlsafe_b64decode("3b-Nqg6ry-jrAuDyVjSwEe8wrdyEPQfPuOQNH1q5olE=")
signing_key = fernet_key[:16]
crypto_key = fernet_key[16:]

fernet_token = base64.urlsafe_b64decode("gAAAAABhBRBGKSwa7AluNJYhwWaHrQGwAA8UpMH8Wtw3tEoTD2E_-nbeoAvxbtBpFiC0ZjbVne_ZetFinKSyMjxwWaPRnXVSVqz5QqpUXp6h-34_TL7BaDs=")
version = fernet_token[:1]
timestamp = fernet_token[1:9]
iv = fernet_token[9:25]
ciphertext = fernet_token[25:-32]
hmac_value = fernet_token[-32:]

def decrypt(ciphertext, key, iv):
    cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend())
    decryptor = cipher.decryptor()
    plaintext_padded = decryptor.update(ciphertext) + decryptor.finalize()
    unpadder = padding.PKCS7(128).unpadder()
    plaintext = unpadder.update(plaintext_padded) + unpadder.finalize()
    return plaintext

def verify_hmac(hmac_value, authenticating, signing_key):
    expected_hmac = hmac.new(signing_key, authenticating, hashlib.sha256).digest()
    return hmac.compare_digest(hmac_value, expected_hmac)

plain_text = decrypt(ciphertext, crypto_key, iv)
print(plain_text, plain_text.decode('utf-8', errors='replace'))
print(verify_hmac(hmac_value, version + timestamp + iv + ciphertext, signing_key))