import cryptography
from cryptography.fernet import Fernet

def generate_key():
    key = Fernet.generate_key()
    return key

def encrypt_message(key, message):
    cipher_suite = Fernet(key)
    cipher_text = cipher_suite.encrypt(message.encode())
    return cipher_text

def decrypt_message(key, cipher_text):
    cipher_suite = Fernet(key)
    plain_text = cipher_suite.decrypt(cipher_text)
    return plain_text.decode()

key = generate_key()
print("Generated Key:", key)

message = "Hello, World!"
print("Original Message:", message)

cipher_text = encrypt_message(key, message)
print("Encrypted Message:", cipher_text)

plain_text = decrypt_message(key, cipher_text)
print("Decrypted Message:", plain_text)