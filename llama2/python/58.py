from cryptography.fernet import Fernet

class Encryptor:
    def __init__(self, key):
        self.key = key
        self.iv = None

    def encrypt(self, raw):
        fern = Fernet(self.key)
        cipher_text = fern.encrypt(raw.encode())
        return cipher_text

    def decrypt(self, cipher_text):
        fern = Fernet(self.key)
        plain_text = fern.decrypt(cipher_text)
        return plain_text.decode()

# Initialize Encryptor with your key
key = Fernet.generate_key()
encryptor = Encryptor(key)

# Encrypt the data
raw = "Hello, World!"
cipher_text = encryptor.encrypt(raw)

# Decrypt the data
plain_text = encryptor.decrypt(cipher_text)

print(f"Raw Text: {raw}")
print(f"Cipher Text: {cipher_text}")
print(f"Plain Text: {plain_text}")