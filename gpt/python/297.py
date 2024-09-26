
from cryptography.fernet import Fernet
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
import base64

def encrypt_string(string_, password, f=None):
    if f is None:
        f = get_fernet_(password)
    try:
        # Directly return the base64 encoded representation of
