
import base64
from Crypto.Cipher import AES
from Crypto.PublicKey import RSA

# Assuming pub_keyObj is initialized somewhere with the RSA public key
# pub_keyObj = RSA.importKey(public_key)

def rsa_encrypt(data):
    return pub_keyObj.encrypt(data, 32)[0]  # Extract the encrypted data from the tuple

def rsa_encrypt_base64(data):
    # rsa_encrypt now returns bytes, which can be directly encoded with base64
    encrypted_data = rsa_encrypt(data)
    return base64.standard_b64encode(encrypted_data)

# Example usage
# encrypted_data = aes_encode(data, AES_key, AES_iv) # AES encoding is working fine
# Replace 'data', 'AES_key', and 'AES_iv' with your actual data and AES parameters
# print("
