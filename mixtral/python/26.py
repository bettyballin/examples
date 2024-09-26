from Cryptodome.Hash import MD5
from base64 import b64encode, b64decode
from Cryptodome.Cipher import DES3

class Crypto:
    def __init__(self):
        self._des = DES3.new(MD5.new("L6#F&q2$xLx".encode()).digest(), mode=DES3.MODE_ECB)

    @staticmethod
    def md5hash(value: str) -> bytes:
        return MD5.new(value.encode('ascii')).hexdigest().encode()

    def encrypt(self, stringToEncrypt):
        ciphertext = self._des.encrypt(stringToEncrypt.encode())
        return b64encode(ciphertext).decode("utf-8")

    def decrypt(self, encryptedString: str) -> bytes:
        try:
            array = b64decode(encryptedString)
            plain_text = self._des.decrypt(array)

            return plain_text

        except Exception as e:

            print(f"Error occurred during decryption: {e}")

# Usage
crypto = Crypto()

cipherText = crypto.encrypt('Hello World')
print(f'Cipher Text : {cipherText}')

plain_text = crypto.decrypt(cipherText).decode("utf-8")
print(f"Plain text: {plain_text}")