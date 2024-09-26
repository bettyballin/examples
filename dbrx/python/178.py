from cryptography.hazmat.primitives.asymmetric import rsa

# Generate private key
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048
)

# Extract modulus (N) and exponent (E)
modulus = private_key.private_numbers().p * private_key.private_numbers().q
exponent = private_key.public_key().public_numbers().e

print(f'Modulus: {modulus}')
print(f'Exponent: {exponent}')

# Extract private exponent (D)
private_exponent = private_key.private_numbers().d
print(f'Private Exponent: {private_exponent}')