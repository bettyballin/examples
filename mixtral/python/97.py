from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

# Using the default backend
default_bk = default_backend()
cipher1 = Cipher(algorithms.AES(b'aa'*16 + b'44'), modes.ECB(), backend=default_bk)

# Or using OpenSSL
from cryptography.hazmat.backends import openssl
openssl_bk = openssl.backend
cipher2 = Cipher(algorithms.AES(b'aa'*16 + b'44'), modes.CBC(b'aba'*8 + b'34'), backend=openssl_bk)