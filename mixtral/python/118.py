from cryptography.hazmat.primitives import serialization

private_key = serialization.load_pem_private_key(
    open('output.pem', 'rb').read(),
    password=None
)