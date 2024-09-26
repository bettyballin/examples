
from cryptography.fernet import Fernet
import json

# Generate a key (you should save this securely!)
key = Fernet.generate_key()

# Create a cipher object
cipher = Fernet(key)

# Your JSON data
data = {
    'secret': 'data',
    'more_secret': 'more data'
}

# Convert JSON data to a string
json_data = json.dumps(data)

# Encrypt the JSON data
encrypted_data = cipher.encrypt(json_data.encode())

# Save the encrypted data to a file
with open('encrypted_data.json', 'wb') as encrypted_file:
    encrypted_file.write(encrypted_data)

# To decrypt the data later on
with open('encrypted_data.json', 'rb') as encrypted_file:
    encrypted_data = encrypted_file.read()

decrypted_data = cipher.decrypt(encrypted_data).decode()

# Convert back to JSON
json_data = json.loads(decrypted_data)

print(json_data)

