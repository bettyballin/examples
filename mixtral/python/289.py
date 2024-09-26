from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

def decrypt(self, ciphertext):
    iv = ciphertext[:16]
    cipher = Cipher(
        algorithms.AES(self.key),
        modes.CBC(iv),
        backend=self.backend
    )

    # Rest of the decrypt method