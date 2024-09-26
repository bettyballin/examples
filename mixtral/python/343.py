from base64 import b64decode
from Crypto.Cipher import AES
from Crypto.Util.Padding import PKCS7

def aes_decryption(encrypted_data, key):
    iv = encrypted_data[:16]  # Assuming the IV is prepended to ciphertext

    decryptor = AES.new(key, AES.MODE_CBC, iv)

    padded_decrypted_bytes = decryptor.decrypt(encrypted_data[16:])

    # Remove PKCS#7 padding
    unpadder = PKCS7(AES.block_size).unpadder()

    return unpadder.update(padded_decrypted_bytes) + unpadder.finalize()

key = b'your-32-byte-secret-key'  # Replace with your secret key
encrypted_data = b64decode('base64encodedciphertext')

plaintext = aes_decryption(encrypted_data, key)
print(plaintext)