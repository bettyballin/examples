import base64
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.fernet import Fernet

# Assuming token and salt are defined
with open("text_encrypted.txt", "wb") as file:
    [file.write(x) for x in (token, salt)]

# Later when decrypting
with open('text_encrypted.txt', 'rb') as f:
    token = base64.urlsafe_b64decode(f.readline())
    salt  = base64.urlsafe_b64decode(f.readline().strip())

kdf = PBKDF2HMAC(
    algorithm=hashes.SHA256(),
    length=32,
    salt=salt,
    iterations=100000
)
key = base64.urlsafe_b64encode(kdf.derive(password))
f = Fernet(key)

# Now you can decrypt