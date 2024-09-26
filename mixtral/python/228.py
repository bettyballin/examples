from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
from Crypto.Hash import SHA256
from Crypto.Signature import PKCS1_v1_5
import hmac
import hashlib

rsa_key = RSA.generate(2048)
decodedString = b"your_string_here"

def oaep_mgf(mgfSeed, maskLen):
    return hmac.new(mgfSeed, digestmod=hashlib.sha256).digest() * (maskLen // 32 + 1)

cipher = PKCS1_OAEP.new(rsa_key, maskGen=oaep_mgf)
ciphertext = cipher.decrypt(decodedString)