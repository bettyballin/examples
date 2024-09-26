from Crypto.Cipher import AES

obj = AES.new('blablablablablab', AES.MODE_CBC, 'a' * 16)
print(obj.encrypt('z' * 16))
print(obj.encrypt('z' * 16))
print(obj.encrypt('z' * 16))