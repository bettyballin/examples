
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from base64 import b64decode
import urllib.parse

def get_encrypted_password(password, modulus, exponent):
    password_bytes = password.encode('utf-8')
    modulus_bytes = b64decode(modulus)
    exponent_bytes = b64decode(exponent)

    # Construct the public key using the modulus and exponent
    n = int.from_bytes(modulus_bytes, byteorder='big')
    e = int.from_bytes(exponent_bytes, byteorder='big')
    public_key = serialization.RSAPublicNumbers(e,
