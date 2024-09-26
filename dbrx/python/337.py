from base64 import b64encode, b64decode
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
from Crypto.Protocol.KDF import PBKDF2

class Crypt:
    def __init__(self, password):
        self.password = password.encode()
        self.salt = b'\x00' * 16
        self.key = self.derive_key(self.password)

    @staticmethod
    def derive_key(password):
        return PBKDF2(password, salt=b'\x00' * 16).read(32)

    def encrypt(self, data):
        cipher = AES.new(self.key, AES.MODE_CBC)
        encrypted_data = b64encode(cipher.encrypt(pad(data.encode(), AES.block_size)))
        iv = b64encode(cipher.iv)
        return f"{iv.decode()}.{encrypted_data.decode()}"

    def decrypt(self, ciphertext):
        try:
            iv_b64, data_b64 = ciphertext.split('.')
            
            cipher = AES.new(self.key, AES.MODE_CBC, IV=b64decode(iv_b64))
            decrypted_data = unpad(cipher.decrypt(b64decode(data_b64)), AES.block_size)
            return decrypted_data.decode()
        
        except (ValueError, TypeError):
            raise ValueError("Invalid ciphertext")

# Usage
encryptor = Crypt("my secret password")
encrypted_text = encryptor.encrypt("hello this is my very secret string")   
print(encrypted_text)
decrypted_text = encryptor.decrypt(encrypted_text)   
print(decrypted_text)