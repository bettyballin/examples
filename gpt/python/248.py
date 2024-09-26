
import os
import binascii

def generate_secure_token(length=32):
    return binascii.hexlify(os.urandom(length)).decode()

# Example usage:
secure_token = generate_secure_token()
print(secure_token)

