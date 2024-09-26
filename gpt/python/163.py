
from cryptography.fernet import Fernet

# Get user input
string = input('String here: ')

# Generate a key and create a cipher suite
key = Fernet.generate_key()
cipher_suite = Fernet(key)

# Convert the string to bytes
string_to_encrypt = string.encode()

# Encrypt the bytes
cipher_text = cipher_suite.encrypt(string_to_encrypt)

# Decrypt the message (for demonstration purposes)
plain_text = cipher_suite.decrypt(cipher_text)

print("Encrypted:", cipher_text)
print("Decrypted:", plain_text.decode())  # Convert bytes back to string

