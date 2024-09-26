from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

key = b'my_secret_key_16b'  # key must be 16 bytes long
iv = b'my_initialization'  # iv must be 16 bytes long

cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend())
aes = cipher.encryptor()
ciphertext = aes.update(b'Hello World!') + aes.finalize()
print(len(ciphertext))