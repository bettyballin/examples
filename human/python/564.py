This is not Python code, but Swift code. Here is the equivalent Python code using the cryptography library:


from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding

def decrypt(ciphertext, key, iv):
    cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=None)
    decryptor = cipher.decryptor()
    padder = padding.PKCS7(128).unpadder()
    decrypted_padded_data = decryptor.update(ciphertext) + decryptor.finalize()
    return padder.update(decrypted_padded_data) + padder.finalize()