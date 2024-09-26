
from cryptography.fernet import Fernet

# Generate a key
key = Fernet.generate_key()

# Save this key securely; you'll need it for decryption
with open('secret.key', 'wb') as key_file:
    key_file.write(key)

# Initialize Fernet instance
cipher_suite = Fernet(key)

# Encrypt a message (the "code" in your case)
def encrypt_message(message: str) -> str:
    # Convert the message to bytes
    encoded_message = message.encode()
    # Encrypt the message
    encrypted_message = cipher_suite.encrypt(encoded_message)
    # Convert to string for storage
    encrypted_message_str = encrypted_message.decode('utf-8
