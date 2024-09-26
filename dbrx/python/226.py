from Crypto.Signature import pkcs1_15
from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA

# Load public key from certificate store (or any other source) as before:
# Replace 'cert.get_public_key()' with your actual public key loading code
public_key = RSA.importKey(b'your_public_key_here')

# Create the same message that was signed earlier
message = b"This is the data I want to sign"

# Hashing algorithm should match what you used for signing
hash_obj = SHA256.new(message)

# Replace 'signature' with your actual signature
signature = b'your_signature_here'

# Verify signature using public key and hashed message
try:
    pkcs1_15.new(public_key).verify(hash_obj, signature)
except (ValueError, TypeError):
    print("Signature verification failed")
else:
    print("Signature verified successfully!")