from base64 import b64decode, b64encode
from Crypto.Cipher import AES
from Crypto.Hash import SHA256
from Crypto.Protocol.KDF import PBKDF2

# Given:
password = b"qwerty0123456789"
iv_hex = "4F6CAB2522DE70629D6DABB100908030"

data_base64 = b"<your_data_here>"
data_b64decoded = b64decode(data_base64)

key_derivation_function = PBKDF2(password, salt=b"", iterations=1, keylen=16, prf=lambda p,s: SHA256.new(p+s).digest())
key = key_derivation_function

iv_bytes = bytes.fromhex(iv_hex)

cipher = AES.new(key, AES.MODE_CBC, iv=iv_bytes)
decrypted_data = cipher.decrypt(data_b64decoded)

print(b64encode(decrypted_data))