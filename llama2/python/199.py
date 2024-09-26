from base64 import b64decode, b64encode
from Crypto.Cipher import AES

data = "FJsww7LryZQFxKnP9TRHoSXNn7OP1/Dsq7vJNiB/I8GUgHxwb2s1dEwSHR0KBD4S"
data = b64decode(data)
iv = b"4F6CAB2522DE70629D6DABB100908030"
key = iv  # AES requires a key, assuming iv is used as key here
cipher = AES.new(key, AES.MODE_CBC, iv)
decoded = cipher.decrypt(data)
print(b64encode(decoded))