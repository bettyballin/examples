import base64
from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

def rsa_encrypt_base64(data, pub_key):
    pub_keyObj = RSA.import_key(pub_key)
    encryptor = PKCS1_OAEP.new(pub_keyObj)
    encrypted_data = encryptor.encrypt(data.encode())
    return base64.standard_b64encode(encrypted_data)

# Example usage:
pub_key = """-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy8Dbv8prpJ3V3JqZT8zT
...
-----END PUBLIC KEY-----"""

data = "Hello, World!"
encrypted_data = rsa_encrypt_base64(data, pub_key)
print(encrypted_data.decode())