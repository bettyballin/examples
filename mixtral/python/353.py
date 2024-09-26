from Crypto.Cipher import DES3
from Crypto.Util import Padding
import base64

def card_encrypt(iv, key, data):
    desT = DES3.new(key, DES3.MODE_CBC, IV=iv)

    # Add PKCS7 padding
    paddedData = Padding.pad(data, 8)

    encryptedData = desT.encrypt(paddedData)

    return base64.b64encode(encryptedData).decode('utf-8')

# Example usage:
iv = b'\x00\x01\x02\x03\x04\x05\x06\x07'
key = b'\x08\x09\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19\x20\x21\x22\x23\x24'
data = b'Hello, World!'

print(card_encrypt(iv, key, data))