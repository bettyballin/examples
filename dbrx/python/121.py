from Crypto.Cipher import AES
import base64

key  = b"1234567890123456"
iv   = b'\0' * 16
cipher = AES.new(key, AES.MODE_CBC, iv)
ctext = cipher.encrypt(b'asasasa')
print(base64.b64encode(ctext).decode())