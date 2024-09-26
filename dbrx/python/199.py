from .encryptors import Encryptor

SECRET_KEY_GENERATOR = Encryptor()  # Generate a new key for each instance.
ENCRYPTOR = SECRET_KEY_GENERATOR.encryptor  # Use this to encrypt/decrypt data.

# Add these lines at the end of settings.py:
with open('secret_key.txt', 'w') as f: 
    f.write(SECRET_KEY_GENERATOR.secret_key.decode())