from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
import base64

key = get_random_bytes(32)  # 256-bit key
iv = get_random_bytes(16)  # 128-bit IV
segment_size = 128

cfb_cipher = AES.new(key, AES.MODE_CFB, iv=iv, segment_size=segment_size)

original_message = b"Hello, World!"
encrypted_payload = base64.b64encode(cfb_cipher.encrypt(original_message))