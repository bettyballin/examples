from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

key = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15\x16\x17\x18\x19\x20\x21\x22\x23'
cipher = Cipher(algorithms.TripleDES(key), modes.ECB(), backend=default_backend())
encryptor = cipher.encryptor()
ct = encryptor.update(b"a secret message") + encryptor.finalize()
print(ct)

decryptor = cipher.decryptor()
pt = decryptor.update(ct) + decryptor.finalize()
print(pt)