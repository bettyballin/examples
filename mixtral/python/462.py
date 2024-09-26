from cryptography.fernet import Fernet

# Generate the key
key = Fernet.generate_key()

# Create an instance of a cipher
cipher_suite = Fernet(key)

print(f"Key: {key} Length: {len(key)}")