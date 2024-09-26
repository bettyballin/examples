from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

key = get_random_bytes(16)
cipher = AES.new(key, AES.MODE_EAX)

secret = u'ककककक.'.encode('utf-8')
cipher.update(secret)
obj, tag = cipher.encrypt_and_digest(secret)

message = u'कककककककककककक'.encode('utf-8')

cipher = AES.new(key, AES.MODE_EAX, cipher.nonce)
cipher.update(secret)
decoded = cipher.decrypt_and_verify(obj, tag).decode('utf-8')

print(decoded)