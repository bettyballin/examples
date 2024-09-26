import os

def generate_secret_key():
    return os.urandom(16)  # Generate a 16-byte random key

# Initialize the secret key for the first time
secret_key = generate_secret_key()

# Save the secret key to a secure storage
def save_secret_key_to_storage(key):
    with open("secret_key.bin", "wb") as f:
        f.write(key)

save_secret_key_to_storage(secret_key)

# Disallow changing the secret key
def set_secret_key(new_key):
    raise ValueError("Secret key cannot be changed")

# Example usage:
print("Generated Secret Key:", secret_key)

try:
    set_secret_key(b"new_key")
except ValueError as e:
    print(e)