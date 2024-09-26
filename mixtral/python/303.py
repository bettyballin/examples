import hashlib
import base64
from Crypto.Cipher import AES

key = hashlib.md5(b"lazydog").digest()
while len(key) < 32:
    key += b'\0'

ciphertext_base64 = "..."  # replace with your ciphertext

iv_ct = base64.decodebytes(ciphertext_base64.encode())
iv = iv_ct[:16]
ct = iv_ct[16:]

decrypted = AES.new(key, AES.MODE_CBC, iv).decrypt(ct)

print("Decryption: ", decrypted.strip().decode())