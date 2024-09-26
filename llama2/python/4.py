import base64
from cryptography.fernet import Fernet

key = Fernet.generate_key()
def encrypt(code):
    f = Fernet(key)
    encrypted_code = f.encrypt(code.encode())
    return base64.b64encode(encrypted_code).decode()

# Test the function
code = "Hello, World!"
encrypted = encrypt(code)
print(encrypted)