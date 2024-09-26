import os

def generate_aes_key():
    return os.urandom(16)

# Generate the AES Key
secret_key = generate_aes_key()

print("Secret Key : ", secret_key)