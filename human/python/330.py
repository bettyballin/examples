from Cryptodome.Cipher import AES
from Cryptodome.Random import get_random_bytes

# Generate a random key
key = get_random_bytes(32)

# Create a cipher suite
cipher_suite = AES.new(key, AES.MODE_EAX)

# Get the password from the password entry
password = input("Enter your password: ").encode("utf-8")

# Encrypt the password
cipher_text, tag = cipher_suite.encrypt_and_digest(password)

# Print the encrypted password
print(cipher_text.hex())