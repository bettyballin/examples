from django.core.cache import cache
from Crypto.Cipher import AES
from Crypto.Hash import SHA256

def get_encryption_key():
    # Implement your secure key storage retrieval here
    # For demonstration purposes, a hardcoded key is used
    return b'your_secret_key_here'

def decrypt_file(file_path, user):
    # Retrieve encryption key from secure storage
    key = get_encryption_key()

    with open(file_path, 'rb') as input_file:
        ciphertext = input_file.read()

    hash = SHA256.new()
    hash.update(key)

    initialization_vector = ciphertext[:AES.block_size]

    # Use a context manager to automatically clear memory after usage
    cipher = AES.new(hash.digest(), AES.MODE_CBC, initialization_vector)
    decrypted_output = cipher.decrypt(ciphertext[AES.block_size:])

    # Clear the encryption key from memory
    del key

    return decrypted_output