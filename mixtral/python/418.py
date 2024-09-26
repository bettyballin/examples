from Crypto.Cipher import AES
import os

with open("mysecrets", "rb") as f:
    nonce, tag, ct_bytes = [f.read(x) for x in (16, 16, -1)]

cipher = AES.new(b'Sixteen byte key', AES.MODE_EAX, nonce=nonce)
data = cipher.decrypt_and_verify(ct_bytes, tag).decode('utf-8')

print("Decrypted:", data)