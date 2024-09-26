from Crypto.Cipher import PKCS1_OAEP, AES
from Crypto.PublicKey import RSA
from base64 import b64encode

# Generate a new 2048-bit key pair (RSA)
key = RSA.generate(2048)

public_key = key.publickey()

# Encrypt the data using symmetric encryption algorithm like AES.
data = "Python Cryptography Toolkit".encode()
cipher_aes = AES.new(key.exportKey('PEM'), AES.MODE_EAX)
ciphertext, tag = cipher_aes.encrypt_and_digest(data)

# Now encrypt the secret key used for above step with RSA public key
encrypted_key = public_key.encrypt(cipher_aes.key, 32)[0]

print("Encrypted data: ", b64encode(encrypted_key).decode())