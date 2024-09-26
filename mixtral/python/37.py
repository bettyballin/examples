from Crypto.Cipher import AES

def __AESEncryptoor(self, k, iv):
    cipher = AES.new(k, AES.MODE_ECB)

    # Encryption
    return cipher.encrypt(iv).hex()

# In decrypt()
ae_block = self.__AESEncryptoor(self.key.decode("hex"), self.IV.string())