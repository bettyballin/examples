import base64
import sys
import urllib.parse
from Crypto.PublicKey.RSA import construct
from Crypto.Cipher import PKCS1_OAEP

def get_encrypted_password(password, modulus, exponent):
    password = password.encode('utf-8')
    n = int.from_bytes(base64.b64decode(modulus), byteorder=sys.byteorder)
    e = int.from_bytes(base64.b64decode(exponent), byteorder=sys.byteorder)

    pubkey = construct((n, e))
    cipher = PKCS1_OAEP.new(pubkey)
    encrypted = urllib.parse.quote_plus(base64.b64encode(cipher.encrypt(password)))

    return encrypted