import base64
import os
import json
from cryptography.fernet import Fernet
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC

print("Insert password: ")
password_str = input()
password = password_str.encode()

# Save salt and iterations count along with encrypted data.
salt = os.urandom(16)
iterations_count = 100000
kdf = PBKDF2HMAC(
    algorithm=hashes.SHA256(),
    length=32,
    salt=salt,
    iterations=iterations_count,
    backend=default_backend()
)

key = base64.urlsafe_b64encode(kdf.derive(password))
f = Fernet(key)

message = "A really secret message. Not for prying eyes.".encode()
token = f.encrypt(message)

# Save encrypted data along with salt and iteration count.
file_data = {
    'salt': salt.hex(),
    'iterations_count': iterations_count,
    'ciphertext': token.decode()
}

with open("text_envelope.json", "w") as file:
    json.dump(file_data, file)