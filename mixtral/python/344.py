from cryptography.hazmat.primitives import padding
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

def unpad(padded_data):
    unpadder = padding.PKCS7(128).unpadder()
    return unpadder.update(padded_data) + unpadder.finalize()

def decrypt(cipherId, n, key, iv):
    cipher = bytes.fromhex(cipherId)
    backend = default_backend()
    cipher_alg = algorithms.AES(key)
    cipher_mode = modes.CBC(iv)
    cipher_obj = Cipher(cipher_alg, cipher_mode, backend=backend)
    dec = cipher_obj.decryptor()

    for _ in range(n):
        id_bytes = dec.update(cipher)

        # Try both codecs
        try:
            node_dec = unpad(id_bytes).decode('utf-8')
        except UnicodeDecodeError:
            node_dec = unpad(id_bytes).decode('ISO-8859-1')

        print(node_dec)

    return node_dec

# Example usage
key = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
iv = b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x10\x11\x12\x13\x14\x15'
decrypt("your_cipher_id", 1, key, iv)