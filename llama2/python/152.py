import cryptography.fernet as fernet

# Generate a secret key
secret_key = fernet.Fernet.generate_key()

# Initialize Fernet with the secret key
fern = fernet.Fernet(secret_key)

# Encrypt the JSON file
with open('data.json', 'rb') as file:
    encrypted_data = fern.encrypt(file.read())

# Save the encrypted data to a new file
with open('encrypted_data.json', 'wb') as file:
    file.write(encrypted_data)