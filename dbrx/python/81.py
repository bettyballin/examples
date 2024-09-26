from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

backend = default_backend()
iv = b'ababababcdcdcdcd1212121234343434'
key = bytes.fromhex('aabbccddaabbccdd1122334411223344')
cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=backend)

e = cipher.encryptor()
ct = e.update(b"Secret messagexx") + e.finalize()

d = cipher.decryptor()
clear = d.update(ct) + d.finalize()

print(clear)