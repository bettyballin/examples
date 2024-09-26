
from cryptography.fernet import Fernet

# Generate a key
key = Fernet.generate_key()

# Instance the Fernet class with the key
cipher_suite = Fernet(key)

# The data to encrypt must be bytes, so encode the string
data = "My super secret data".encode()

# Encrypt the data
cipher_text = cipher_suite.encrypt(data)
print("Encrypted:", cipher_text)

# Decrypt the data
plain_text = cipher_suite.decrypt(cipher_text)
print("Decrypted:", plain_text.decode())

