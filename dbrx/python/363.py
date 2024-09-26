from base64 import b64decode, b64encode
from Crypto.Cipher import AES
from Crypto.Protocol.KDF import PBKDF2

# Given:
password = "qwerty0123456789"
iv_hex = "4F6CAB2522DE70629D6DABB100908030"

data_base64 = "<your_data_here>"
data_b64decoded = b64decode(data_base64)

key_derivation_function = PBKDF2(password, salt=b"", iterations=1)
key = key_derivation_function.read(16)  # AES-128 uses a 16-byte (128-bit) key

iv_bytes = bytes.fromhex(iv_hex)

cipher = AES.new(key, AES.MODE_CBC, iv=iv_bytes)
decrypted_data = cipher.decrypt(data_b64decoded)

print(b64encode(decrypted_data))