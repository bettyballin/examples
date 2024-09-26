from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from base64 import urlsafe_b64encode

def token_hex(nbytes):
    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=nbytes,
        salt=b'salt',
        iterations=1
    )
    return urlsafe_b64encode(kdf.derive(b'seed')).decode('utf-8')

print(token_hex(32))