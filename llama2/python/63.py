import Crypto.Random
from Crypto.PublicKey import RSA
from Crypto.Util.Padding import pad, unpad

# Generate random keys
keyAlice = RSA.generate(2048)
keyBob = RSA.generate(2048)

# Define a fixed-length padding string
padding = b'0123456789abcdef'

# Encrypt the message using Alice's public key
x = Crypto.Random.get_random_bytes(32)
ciphertext = keyAlice.encrypt(x + padding)

# Decrypt the ciphertext using Alice's private key
plaintext = keyAlice.decrypt(ciphertext)

# Remove padding
plaintext = plaintext[:-len(padding)]

print(plaintext == x)