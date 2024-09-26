
from Crypto.Cipher import AES
from Crypto import Random
from base64 import b64encode, b64decode
import hashlib
import padding

key = 'lazydog'.encode('utf-8')
key = hashlib.sha256(key).digest()

# The IV should be the same as you used in your JS code.
# If you're using CryptoJS's default IV (which is essentially a zero IV), you should do the same here.
iv = b"\0" * 16  # This is equivalent to a zero IV in AES encryption

# Make sure your plaintext is padded correctly.
# In CryptoJS, PKCS7 padding is used by default. You need to replicate this padding in Python.
plaintext = 'Attack at dawn'.encode('utf-8')
padded_plaintext = padding.pad(plaintext, AES.block_size, style='pkcs7')

cipher = AES.new(key, AES.MODE_CBC, iv)
encrypted_msg = cipher.encrypt(padded_plaintext)

#
