import os
import hashlib
import hmac
from Crypto.Cipher import AES

def encrypt(file, publicKey):
    # Generate a random session key
    sessionKey = os.urandom(32)

    # Encrypt the file using AES-GCM
    cipher = AES.new(sessionKey, AES.MODE_GCM)
    with open(file, "rb") as f:
        data = f.read()
    encryptedData, tag = cipher.encrypt_and_digest(data)

    # Compute the authentication tag
    mac = hmac.new(publicKey, digestmod=hashlib.sha256)
    mac.update(sessionKey)
    authTag = mac.hexdigest()

    # Save the encrypted data
    with open(file + ".enc", "wb") as f:
        f.write(cipher.nonce + encryptedData + tag)

# Usage:
publicKey = b"your_public_key_here"
encrypt("path_to_your_file", publicKey)