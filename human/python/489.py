from cryptography.hazmat.backends import default_backend as defb
from cryptography.hazmat.primitives.poly1305 import Poly1305
from cryptography.hazmat.primitives.ciphers import Cipher
from cryptography.hazmat.primitives.ciphers import algorithms as algo

class ChaCha20Poly1305:
    def __init__(self, encrypt, key, nonce):
        self._encrypt = encrypt
        self._dataLength = 0
        self._aadLength = 0
        self._nonceCounter = (0).to_bytes(4, byteorder='little') + nonce
        self._nonceEncrypt = (1).to_bytes(4, byteorder='little') + nonce
        
        cipher = Cipher(algo.ChaCha20(key, self._nonceEncrypt), None, defb())
        if encrypt:
            self._cipher = cipher.encryptor()
        else:
            self._cipher = cipher.decryptor()
        
        polyKey = self.__getPolyKey(key)
        self._auth = Poly1305(polyKey)
    
    def updateAAD(self, aad):
        self._auth.update(aad)
        self._aadLength = len(aad)
        self._auth.update(self.__getZeroBytes(self._aadLength))

    def update(self, data):
        ctxt = self._cipher.update(data)
        self._dataLength += len(ctxt)
        if self._encrypt:   
            self._auth.update(ctxt)
        else:
            self._auth.update(data)
        return ctxt

    def verify_tag(self, tag=None):
        if not self._encrypt:
            self.__pad()
            if tag is None:
                raise ValueError('tag required')
            self._auth.verify(tag)
        else:
            raise ValueError('Tag verification only during decryption')

    def calculate_tag(self):
        if self._encrypt:
            self.__pad()
            return self._auth.finalize()
        else:
            raise ValueError('Tag calculation only during encryption')
        
    def __pad(self):
        self._auth.update(self.__getZeroBytes(self._dataLength))
        self._auth.update(self._aadLength.to_bytes(8, byteorder='little'))
        self._auth.update(self._dataLength.to_bytes(8, byteorder='little'))

    def __getZeroBytes(self, len):
        spareBytes = len % 16
        if (spareBytes != 0):
            length = 16 - spareBytes
            return bytes([0]) * length
        return b''

    def __getPolyKey(self, key):
        cipher = Cipher(algo.ChaCha20(key, self._nonceCounter), None, defb())
        cipher = cipher.encryptor()
        key = cipher.update(b'\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0')
        return key

# Example usage:
key = b'\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0'
nonce = b'\0\0\0\0\0\0\0\0\0\0\0\0'
encryptor = ChaCha20Poly1305(True, key, nonce)
plaintext = b'Hello, World!'
aad = b'Authenticated Data'
ciphertext = encryptor.update(plaintext)
tag = encryptor.calculate_tag()
print("Ciphertext:", ciphertext.hex())
print("Tag:", tag.hex())

decryptor = ChaCha20Poly1305(False, key, nonce)
decryptor.updateAAD(aad)
decrypted_text = decryptor.update(ciphertext)
decryptor.verify_tag(tag)
print("Decrypted text:", decrypted_text.decode())