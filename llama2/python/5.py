from cryptography.fernet import Fernet
import base64

key = Fernet.generate_key()
f = Fernet(key)

def decrypt(encrypted_code):
    decoded_code = base64.b64decode(encrypted_code)
    return f.decrypt(decoded_code)

# Example usage:
encrypted_code = f.encrypt(b"Hello, World!")
print(decrypt(encrypted_code))