from base64 import b64decode
from Crypto.Cipher import AES

def evp_bytes_to_key(password, salt=b'\x00'*8):
    # Implementation of OpenSSL EVP_BytesToKey function
    key = bytearray()
    while len(key) < 32:
        key.extend(AES.new(password, AES.MODE_ECB).encrypt(salt))
        salt = salt[1:] + b'\x00'
    return bytes(key[:32])

data = "BASE64-ENCODED-PRIVATE-KEY"
salted_private_key = b64decode("SALTED-AND-CIPHERTEXT")

# Extract salt and ciphertext
salt = salted_private_key[:8]
encrypted = salted_private_key[8:]

# Use EVP_BytesToKey to derive key from password
password = b"YOUR-PASSWORD-HERE"
key = evp_bytes_to_key(password, salt)

# Decrypt ciphertext
cipher = AES.new(key, AES.MODE_ECB)
decrypted = cipher.decrypt(encrypted)

print(decrypted.decode())