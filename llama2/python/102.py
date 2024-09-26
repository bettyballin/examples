import cryptography
from cryptography.fernet import Fernet
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes

# Generate a secure encryption key per user
key = Fernet.generate_key()

password = "mysecretpassword"

# Store the encrypted password for the user
password_hash = hashes.Hash(hashes.SHA256(), default_backend())
password_hash.update(password.encode())
password_hash = password_hash.finalize()

# Verify the user's entered password
def verify_password(entered_password):
    entered_password_hash = hashes.Hash(hashes.SHA256(), default_backend())
    entered_password_hash.update(entered_password.encode())
    return entered_password_hash.finalize() == password_hash

# Use the securely stored encryption key to encrypt and decrypt sensitive data
def encrypt(data):
    f = Fernet(key)
    return f.encrypt(data.encode())

def decrypt(encrypted_data):
    f = Fernet(key)
    return f.decrypt(encrypted_data).decode()

# Test the functions
data = "Hello, World!"
encrypted_data = encrypt(data)
print("Encrypted data:", encrypted_data)

decrypted_data = decrypt(encrypted_data)
print("Decrypted data:", decrypted_data)

entered_password = "mysecretpassword"
print("Password verification:", verify_password(entered_password))