import os
import base64

def generate_token(length=40):
    # Generate random bytes suitable for cryptography
    bytes = os.urandom(length)

    # Convert the bytes into an alphanumeric string
    token = base64.b36encode(bytes).decode()

    return token

print(generate_token())