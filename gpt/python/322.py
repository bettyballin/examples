
def decrypt(self, ciphertext):
    ciphertext = base64.b64decode(ciphertext.rstrip())
    iv = ciphertext[:16]
    actual_ciphertext = ciphertext[16:]
    cipher = Cipher(
        algorithms.AES(self.key),
        modes.CBC(iv),
        backend=self.backend
    )

    decryptor = cipher.decryptor()
    unpadder = padding.PKCS7(256).unpadder()
    decrypted = decryptor.update(actual_ciphertext) + decryptor.finalize()
    unpadded = unpadder.update(decrypted) + unpadder.finalize()
    return unpadded.decode('utf-8')

