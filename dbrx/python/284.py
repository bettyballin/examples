from cryptography.hazmat.primitives import serialization

private_key = b"""-----BEGIN ENCRYPTED PRIVATE KEY-----
MIIE6TAbBgkqhki....
-----END ENCRYPTED PRIVATE KEY-----"""
password = b"your_password_here"

# Load the private key from PEM format
loaded_private_key = serialization.load_pem_private_key(
    data=private_key,
    password=password,
)

# Convert it to an RSA object and serialize back into a string in PKCS1 format (RSA)
rsa_private_key = loaded_private_key.private_numbers()
pem_rsa_private_key = rsa_private_key.private_key().public_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.TraditionalOpenSSL,
)

print(pem_rsa_private_key.decode())