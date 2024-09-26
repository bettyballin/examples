
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import rsa

# Generate a private RSA key
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)

# Access the private key components
n = private_key.public_key().public_numbers().n
e = private_key.public_key().public_numbers().e
d = private_key.private_numbers().d
p = private_key.private_numbers().p
q = private_key.private_numbers().q
dmp1 = private_key.private_numbers().dmp1
dmq1 = private_key.private_numbers().dmq1
iqmp = private_key.private_numbers().iqmp

# Print the components
print(f"n (modulus): {n}")
print(f"e (public exponent): {e}")
print(f"d (private exponent): {d}")
print(f"p (
