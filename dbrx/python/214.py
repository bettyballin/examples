import hashlib

def sha512_hash(password, salt):
    return hashlib.sha512(salt.encode() + password.encode()).hexdigest()

password = 'password'
salt = '$6$salt1234'

print(sha512_hash(password, salt))