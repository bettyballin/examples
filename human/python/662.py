from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

# assuming 'res' is the decrypted data
res = b'\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15\x16'

unpadder = padding.PKCS7(128).unpadder()
decrypted = unpadder.update(res) + unpadder.finalize()
print(decrypted.decode('utf8'))