from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.backends import default_backend

key = rsa.generate_private_key(
    public_exponent=65537,
    key_size=2048,
    backend=default_backend()
)

der_bytes = key.private_bytes(
    encoding=serialization.Encoding.DER,      
    format=serialization.PrivateFormat.TraditionalOpenSSL, 
    encryption_algorithm=serialization.NoEncryption()
)

assert der_bytes[5:7] == b'\x04\x20'
key_bytes = der_bytes[7:39]