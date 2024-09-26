from base64 import b64decode
from Crypto.PublicKey.RSA import construct
from Crypto.Cipher import PKCS1_v1_5
import urllib.parse

def get_encrypted_password(password, modulus, exponent):
    password = password.encode('utf-8')

    # decode base64 string to be used as modulus(n) and exponent(e) components for
    # constructing the RSA public key object

    modulus = b64decode(modulus)
    exponent = b64decode(exponent)

    n = int.from_bytes(modulus, byteorder='big')
    e = int.from_bytes(exponent, byteorder='big')

    pubkey = construct((n, e))
    pubkey = PKCS1_v1_5.new(pubkey)
    encrypted = pubkey.encrypt(password)
    # url encode the encrypted password
    encrypted = urllib.parse.quote_plus(encrypted)
    return encrypted

if __name__ == "__main__":
    password = input("Enter password: ")
    modulus = input("Enter modulus (base64 encoded): ")
    exponent = input("Enter exponent (base64 encoded): ")
    encrypted_password = get_encrypted_password(password, modulus, exponent)
    print("Encrypted password:", encrypted_password)