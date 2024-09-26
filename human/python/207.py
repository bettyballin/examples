import hashlib

password = "your_password"
e = "your_salt"

res = hashlib.pbkdf2_hmac('sha1', password.encode(), e.encode(), 10000, 32)

print(res)