from cryptography.fernet import Fernet
import base64

# Generate key once.
key = Fernet.generate_key()
print("Generated Key:", key)

# Store it securely (e.g in a database).
stored_key_base64 = base64.urlsafe_b64encode(key).decode('utf-8')
print("Stored Base64-encoded Key:", stored_key_base64)

# Retrieve the encoded key from storage.
retrieved_key_base64 = input("Enter Stored Encoded Key: ")
decoded_retrieved_key = bytes(retrieved_key_base64, 'utf-8')

# Decode it back into a Fernet-compatible format.
key_to_use_for_decryption = base64.urlsafe_b64decode(decoded_retrieved_key)

# Now you can use this key for decryption:
fernet_instance = Fernet(key_to_use_for_decryption)
encrypted_data = fernet_instance.encrypt(b"Hello World!")
decrypted_data = fernet_instance.decrypt(encrypted_data)

print("Decrypted Data:", decrypted_data.decode('utf-8'))