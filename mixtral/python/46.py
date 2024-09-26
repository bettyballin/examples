from base64 import b64encode
from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

def rsa_encrypt(data, pubkey):
    # Load the public key
    rsakey = RSA.importKey(pubkey)
    cipher = PKCS1_OAEP.new(rsakey)

    # Encrypt data
    ciphertext = cipher.encrypt(data.encode())

    return b64encode(ciphertext)

# Example usage
pubkey = b'-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn1pMVSEDO4EPzQxKgAakFxRgMGiewWZFAktenWo5aMt/OIso\n3ZF+aZh8gCgYEA9jRgfQvWowpemlaTqci9nKffWXSjNWw9n/4ygZoeX3FjVnjgj\nV7v0KkKrV4qQ6YU4UjM0V20r4c9e+7YsWV3Mm+HEm\n-----END PUBLIC KEY-----'
data = 'Hello, World!'
encrypted = rsa_encrypt(data, pubkey)
print(encrypted)