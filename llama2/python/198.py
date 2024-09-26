from cryptography.fernet import Fernet
import ecdsa

# Generate a secure key for encryption
key = Fernet.generate_key()

# Generate a public key using the SECP256k1 curve
public_key = ecdsa.SigningKey.generate(curve=ecdsa.SECP256k1).get_verifying_key()

# Compress the public key
prefix = '02' if public_key.point.y % 2 == 0 else '03'
x = '%064x' % public_key.point.x
compressed_key = '%s%s' % (prefix, x)

# Encrypt the compressed key using Fernet
encrypted_key = Fernet(key).encrypt(compressed_key.encode())

# Store the encrypted and compressed public key
def store_data(data):
    with open('encrypted_key.txt', 'wb') as f:
        f.write(data)

store_data(encrypted_key)