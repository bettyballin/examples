from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.backends import default_backend
import base64

password = b'1Lw2*kx18#AvNuij*iRL1nY1UA_#k8$+'
salt = b'somesalt'  # cannot be empty
iterations = 100000  # should be higher for better security
key_length = 32

kdf = PBKDF2HMAC(
    algorithm=hashes.SHA256(),  # MD5 is insecure, use SHA256 instead
    length=key_length,
    salt=salt,
    iterations=iterations,
    backend=default_backend()
)

key = base64.b64encode(kdf.derive(password))

print(key)