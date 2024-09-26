from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import serialization

priv_rsakey = serialization.load_pem_private_key(
    b'your_private_key_here', 
    password=None, 
    backend=default_backend()
)