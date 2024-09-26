import os
from base64 import b64encode, b64decode
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad

class Token:
    def __init__(self):
        self.__COMMON_ENC_KEY = os.getenv("ENCRYPTION_KEY")
        self.__IV16 = os.getenv("AES_IV16")

        if not (self.__COMMON_ENC_KEY and self.__IV16):
            raise ValueError("[coablt] Encryption key or IV is missing.")

    def __common(self) -> AES:
        try:
            return AES.new(self.__COMMON_ENC_KEY, AES.MODE_CBC, self.__IV16)
        except ValueError as e:
            raise Exception("[coablt] Error creating cipher object.") from e

    def encrypt(self, token):
        common = self.__common()

        padded_token = pad(token.encode())

        raw_encrypted_token = common.encrypt(padded_token)

        return b64encode(raw_encrypted_token).decode('utf-8')

    def decrypt(self, encrypted):
        common = self.__common()

        raw_decoded_token = b64decode(encrypted.encode())

        decrypted_padded_token = common.decrypt(raw_decoded_token)

        return unpad(decrypted_padded_token).decode('utf-8')