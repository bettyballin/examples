
from cryptography.hazmat.primitives.ciphers import Cipher, modes, algorithms
from cryptography.hazmat.backends import default_backend
from Crypto.Cipher import AES

key = b'Sixteen byte key'
iv = b'Sixteen byte ivv'
cipher1 = AES.new(key, AES.MODE_CFB, iv)
cipher2 = Cipher(algorithms.AES(key), modes.CFB(iv), default_backend())

plaintext = b"Plaintext"

# Encrypt with pycrypto
ciphertext1 = cipher1.encrypt(plaintext)
print(ciphertext1)

# Decrypt with pycrypto (should use the ciphertext obtained from encryption)
print(cipher1.decrypt(ciphertext1))

# Encrypt with cryptography.io
encryptor = cipher2.encryptor()
ciphertext2 = encryptor.update(plaintext) + encryptor
