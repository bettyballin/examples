import hashlib

class Crypto:
    def __init__(self):
        self.salt = "secret_key"

    def encrypt(self, text):
        return hashlib.sha256((text + self.salt).encode()).hexdigest()

    def decrypt(self, text):
        # Note: Since we're using a one-way hash function (SHA-256), 
        #       decryption is not possible. This function will always return False.
        return False

crypto = Crypto()

print(crypto.encrypt("abcd") == crypto.encrypt("abcd"))