from cryptography.fernet import Fernet

key = Fernet.generate_key()
cipher = Fernet(key)

plaintext = b'Hello World!'
ciphertext = cipher.encrypt(plaintext)

print(ciphertext.decode())