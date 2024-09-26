from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import base64
import sys

def decode_rsa(encrypted_string, key_path):
    with open(key_path) as f:
        der = f.read()

    rsa_key = RSA.importKey(der)
    cipher = PKCS1_OAEP.new(rsa_key)

    decoded_string = base64.b64decode(encrypted_string)

    # Specify OAEP padding scheme
    ciphertext = cipher.decrypt(decoded_string)

    return ciphertext

print(decode_rsa(sys.argv[1], sys.argv[2]))