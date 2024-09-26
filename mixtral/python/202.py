import os
from Crypto.Cipher import AES
from Crypto.Hash import SHA256
from Crypto.Util.Padding import pad, unpad

k = 'mykey'
hash_obj = SHA256.new(data=k.encode())
k = hash_obj.digest()

p = b"eniigmaticaurabbbb"
print("Original: ", p)

IV = os.urandom(16)

# Pad the plaintext to a multiple of 16 bytes
p_padded = pad(p, AES.block_size)

encryptor = AES.new(k, mode=AES.MODE_CBC, IV=IV)
for _ in range(2):
    p_padded = encryptor.encrypt(p_padded)

decryptor = AES.new(k, mode=AES.MODE_CBC, IV=IV)
for _ in range(2):
    # Remove padding after each decryption
    p_padded = decryptor.decrypt(p_padded)

p_unpadded = unpad(p_padded, AES.block_size)

print("Decrypted: ", p_unpadded)