from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

ecurve = ec.SECP256R1()

private_key, public_key = ec.generate_private_key(ecurve, default_backend()), ec.generate_private_key(ecurve, default_backend()).public_key()

# Optional: serialization
private_pem = private_key.private_bytes(
    encoding=serialization.Encoding.PEM,
    format=serialization.PrivateFormat.PKCS8,
    encryption_algorithm=serialization.NoEncryption()
)

public_pem = public_key.public_bytes(
    encoding=serialization.Encoding.OpenSSH,
    format=serialization.PublicFormat.OpenSSH
)

print(private_pem.decode('utf-8'))
print(public_pem.decode('utf-8'))