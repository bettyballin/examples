from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

with open("encrypted_private_key.pem", "rb") as f:
    pem = f.read()

password = "my_passphrase".encode("utf-8")

private_key = serialization.load_pem_private_key(
    data=pem,
    password=password,
    backend=default_backend()
)

rsa_format_private_key = private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.PKCS8,
    encryption_algorithm=serialization.NoEncryption()
).decode("utf-8")

with open("rsa_format_private_key.pem", "w+b") as f:
    f.write(rsa_format_private_key.encode("utf-8"))