
from Crypto.PublicKey import RSA
from Crypto.Signature import pkcs1_15
from Crypto.Hash import SHA256

# Replace 'path/to/private_key.pem' with the path to your PEM file
with open('path/to/private_key.pem', 'r') as pem_file:
    private_key_data = pem_file.read()

# Load the private key from the PEM file
private_key = RSA.import_key(private_key_data)

# Assuming you want to sign some data
data_to_sign = b'This is the data to sign'
hash_value = SHA256.new(data_to_sign)

# Sign the data
signature = pkcs1_15.new(private_key).sign(hash_value)

# Signature is now the signature
