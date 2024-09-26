from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

def des_encrypt(key: bytes, data: bytes) -> bytes:
    cipher = Cipher(algorithms.TripleDES(key), modes.CBC(b'\0' * 8), backend=default_backend())
    encryptor = cipher.encryptor()
    encrypted_data = encryptor.update(data)
    return b''.join([encrypted_data, encryptor.finalize()])

def des_decrypt(key: bytes, data: bytes) -> bytes:
    decipher = Cipher(algorithms.TripleDES(key), modes.CBC(b'\0' * 8), backend=default_backend())
    decryptor = decipher.decryptor()
    decrypted_data = decryptor.update(data)
    return b''.join([decrypted_data, decryptor.finalize()])

key = b"your_8_byte_key"
encoded_message = b"your_message_to_encrypt"

key = key[:8] + (b'\0' * 16)  # Use only the first block of DES key
encrypted_message = des_encrypt(key, encoded_message)
decoded_message = des_decrypt(key, encrypted_message)

print(f"Encrypted Message: {encrypted_message.hex()}")
print(f"Decrypted Message: {decoded_message.decode()}")