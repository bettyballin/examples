
from cryptography.fernet import Fernet

# Generate a key
key = Fernet.generate_key()
cipher_suite = Fernet(key)

# Encrypting data
def encrypt_field(data):
    return cipher_suite.encrypt(data.encode('utf-8'))

# Decrypting data
def decrypt_field(encrypted_data):
    return cipher_suite.decrypt(encrypted_data).decode('utf-8')

# Example usage
original_data = "Sensitive information"
encrypted_data = encrypt_field(original_data)
decrypted_data = decrypt_field(encrypted_data)

print(f"Original: {original_data}")
print(f"Encrypted: {encrypted_data}")
print(f"Decrypted: {decrypted_data}")

