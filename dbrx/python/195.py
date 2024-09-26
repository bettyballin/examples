import base64
import os
import json
from cryptography.fernet import Fernet
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC

# Load encrypted data along with salt and iteration count.
with open("text_envelope.json", "r") as file:
    file_data = json.load(file)