
import numpy as np
from Crypto.Cipher import AES
from Crypto import Random
import hashlib
import base64

class AESCipher(object):
    def __init__(self, key): 
        self.bs = AES.block_size
        self.key = hashlib.sha256(key.encode()).digest()
        
    def encrypt(self, data):
        raw = self
