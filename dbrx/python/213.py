import os
from base64 import b64encode, b64decode

from cryptography.hazmat.primitives.ciphers.aead import AESGCM
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.backends import default_backend


class SecureAES256Cipher:
    def __init__(self, password: str, salt: bytes):
        self.password = password.encode("utf-8")
        self.salt = salt

        kdf = PBKDF2HMAC(
            algorithm=hashes.SHA256(),
            length=32,
            salt=self.salt,
            iterations=100000,
            backend=default_backend()
        )
        key_material = kdf.derive(self.password)
        self.key = AESGCM(key_material)

    def encrypt(self, plaintext: str) -> bytes:
        nonce = os.urandom(12)
        ciphertext = self.key.encrypt(nonce, plaintext.encode("utf-8"), None)
        return b64encode(nonce + ciphertext)

    def decrypt(self, encrypted_data: bytes) -> str:
        decoded_encrypted_data = b64decode(encrypted_data)
        nonce = decoded_encrypted_data[:12]
        decrypted_text = self.key.decrypt(nonce, decoded_encrypted_data[12:], None).decode("utf-8")
        return decrypted_text


# Example usage:
if __name__ == "__main__":
    password = "my_secret_password"
    salt = os.urandom(16)

    cipher = SecureAES256Cipher(password, salt)

    plaintext = "Hello, World!"
    encrypted_data = cipher.encrypt(plaintext)
    print(f"Encrypted data: {encrypted_data}")

    decrypted_text = cipher.decrypt(encrypted_data)
    print(f"Decrypted text: {decrypted_text}")