from Crypto.Util.Padding import pad
import base64
from Crypto.Cipher import DES3

def card_encrypt(data):
    key = b'SecureKeyHere168'  # 24 bytes for 3DES
    cipher = DES3.new(key, DES3.MODE_ECB)
    data = base64.b64encode(pad(data.encode('utf-8'), DES3.block_size))
    return cipher.encrypt(data)

# Example usage:
encrypted_data = card_encrypt("1234-5678-9012-3456")
print(encrypted_data)