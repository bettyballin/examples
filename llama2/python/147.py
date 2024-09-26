from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import hashes

# Generate a new private key and certificate (replace with your own loading code)
private_key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)
cert = private_key.public_key().public_bytes(
    encoding=serialization.Encoding.DER,
    format=serialization.PublicFormat.SubjectPublicKeyInfo
)

# Create an RSA algorithm object
algorithm = private_key

# Serialize the certificate to a byte string
cert_bytes = cert

# Sign the data
data = b"Hello world!"
signature = algorithm.sign(
    data,
    hashes.SHA256(),
    default_backend()
)

# Verify the signature
try:
    algorithm.public_key().verify(
        signature,
        data,
        hashes.SHA256(),
        default_backend()
    )
    verified = True
except:
    verified = False

print(verified)