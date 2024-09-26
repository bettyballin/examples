from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
import base64

payload = b"hello"
derived_key = base64.b64decode("LefjQ2pEXmiy/nNZvEJ43i8hJuaAnzbA1Cbn1hOuAgA=")
iv = b"1020304050607080"

cipher = AES.new(derived_key, AES.MODE_CBC, iv)
ct = cipher.encrypt(pad(payload, 16))

print(base64.b64encode(ct).decode())