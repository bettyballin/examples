from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
import base64

def encrypt(data, key):
    iv = get_random_bytes(16)
    cipher = AES.new(key, AES.MODE_CBC, iv)
    ciphertext = cipher.encrypt(data)
    return base64.b64encode(iv + ciphertext)

KEY = b'your_256_bit_key_here'
data = b'your_data_here'
DATA = encrypt(data, KEY)
print(DATA)