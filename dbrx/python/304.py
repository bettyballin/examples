from Crypto.PublicKey import ECC
from Crypto.Cipher import AES

# Generate a new private/public ECDSA key pair
key = ECC.generate(curve='P-256')

# Their ephemeral public key (replace with actual key)
ephemeral_public_key = key.public_key().export_key(format='PEM')

# Derive the shared secret from your private key and their public key
shared_secret = key.exchange(ECC.import_key(ephemeral_public_key))

# Now you can use this derived shared secret to generate a symmetric encryption/decryption key
key_aes = AES.new(shared_secret[:32], AES.MODE_EAX)  # Use 32 bytes (256 bits) for AES key

# Data to encrypt (replace with actual data)
data = b'Hello, World!'

# Encrypt some data with the generated symmetrical key
ciphertext, tag = key_aes.encrypt_and_digest(data)

print(ciphertext)
print(tag)