import cryptography.fernet as fernet
import base64
import hashlib

hashed_password = b"1234567890abcdef"  # hashed password from Java
password = "mysecretpassword"  # user-supplied password

# Create a new Fernet instance with a key
key = fernet.Fernet.generate_key()
cipher_suite = fernet.Fernet(key)

# Hash the user-supplied password using SHA-256
hashed_user_password = hashlib.sha256(password.encode()).digest()

# Verify the hashed user-supplied password with the hashed password from Java
try:
    cipher_suite.verify(base64.urlsafe_b64encode(hashed_user_password), base64.urlsafe_b64encode(hashed_password))
    print(True)
except fernet.InvalidSignature:
    print(False)