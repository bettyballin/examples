import base64
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend

algorithm = 'AES'
key = b'LKOXBRRUNBOSMENKEPPZUKWB'
byte_seq = b'HOJFKGQMRCTKUQHPHOJFKGQMRCTKUQHP'
ciphertext = base64.b64decode('r7G8gFNIHuY27nBjSo51nZ6mqZhVUQ==')

# Encrypt the byte-sequence generated from the IV (no incrementation)
cipher = Cipher(algorithms.AES(key), modes.ECB(), backend=default_backend())
encryptor = cipher.encryptor()
padder = padding.PKCS7(128).padder()
padded_data = padder.update(byte_seq) + padder.finalize()
byte_seq_enc = encryptor.update(padded_data) + encryptor.finalize()

# XORing of ciphertext and IV
decrypted = bytes([x ^ y for x, y in zip(ciphertext, byte_seq_enc)])
print("Decrypted: " + decrypted.decode('utf8'))