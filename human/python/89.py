from pyDes import *
import hashlib
import base64

key = hashlib.md5("L6#F&q2$xLx".encode()).digest()
data = "I love security"

k = triple_des(key, ECB, b"\0\0\0\0\0\0\0\0", pad=None, padmode=PAD_PKCS5)
d = k.encrypt(data.encode())
base64Encrypted = base64.b64encode(d)

print("Encrypted: %r" % d)

base64Decrypted = base64.b64decode(base64Encrypted)
print("Decrypted: %r" % k.decrypt(base64Decrypted).decode())