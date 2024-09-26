import hashlib

def get_sha512(data):
    return hashlib.sha512(data).hexdigest()

print(get_sha512("Hello World!".encode()))