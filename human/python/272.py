from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

# Generate a new RSA key pair
key = RSA.generate(2048)

# Export the private key
privkey = key.exportKey()

# Create a new PKCS1_OAEP cipher object with the private key
privcipher = PKCS1_OAEP.new(key)