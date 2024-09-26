from cryptography.fernet import Fernet

# Generate a key
key = Fernet.generate_key()
cipher_suite = Fernet(key)

# Encrypt a message
message = "a secret message"
encrypted = cipher_suite.encrypt(message.encode())

print("Encrypted:", encrypted)

# Decrypt the message
decrypted = cipher_suite.decrypt(encrypted).decode()

print("Decrypted:", decrypted)