from Crypto.Cipher import AES
from base64 import b64decode
import requests

url = "your_url_here"
key = "your_key_here"
iv = "your_iv_here"

content = requests.get(url)
message = content.content
dec_key = b64decode(key)
dec_iv = b64decode(iv)
obj = AES.new(dec_key, AES.MODE_CBC, dec_iv)
decrypt_text = obj.decrypt(message)

print(decrypt_text.decode())