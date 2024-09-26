from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.hkdf import HKDF

psw = b'your_password_here'  # replace with your password

hkdf = HKDF(
    algorithm=hashes.SHA256(),
    length=48,
    salt=None,
    info=b'',
)

key_and_iv = hkdf.derive(psw)
print(key_and_iv)