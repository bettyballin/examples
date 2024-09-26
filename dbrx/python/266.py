import hashlib

def sha256_encrypt(string):
    result = hashlib.sha256(string.encode())
    return result.hexdigest()

string_to_encrypt = "Hello, World!"
encrypted_string = sha256_encrypt(string_to_encrypt)
print(encrypted_string)