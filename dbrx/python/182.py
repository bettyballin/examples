from cryptography.fernet import Fernet
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
import base64

def encrypt_string(string, password, f=None):
    if f is None:
        f = get_fernet_(password)
    try:
        return str(f.encrypt(string.encode()))[2:-1]
    except Exception as e:
        print(e)
        return None

def decrypt_string(encrypted_str, password, f=None):
    if f is None:
        f = get_fernet_(password)
    try:
        decrypted_bytes = f.decrypt(bytes(encrypted_str, 'utf-8'))
        decoded_str = decrypted_bytes.decode()
        return decoded_str
    except Exception as e:
        print(e)
        return None

def get_fernet_(password):
    if password and isinstance(password, str):
        kdf = PBKDF2HMAC(
            algorithm=hashes.SHA256(),
            length=32,
            salt=password.encode(),
            iterations=100000,
            backend=default_backend()
        )
        key = base64.urlsafe_b64encode(kdf.derive(password.encode()))
        f = Fernet(key)
        return f

def test_encryption(s="text", password="key"):
    my_f = get_fernet_(password)
    s2 = encrypt_string(s, password)
    s3 = decrypt_string(s2, password)
    if s == s3:
        print(f"Test passed for '{s}'")
        return True

print(test_encryption("text"))
print(test_encryption("t\t\\ta"))