import json
from cryptography.hazmat.primitives import serialization as crypto_serialization
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.backends import default_backend

private_key_pem = "/etc/ssl/nginx/snbcsr.key"
with open(private_key_pem, "rb") as key_file:
    private_key = crypto_serialization.load_pem_private_key(
        key_file.read(),
        password=None,
        backend=default_backend()
    )

actual = {
    # your payload here
}

signer = private_key.signer(
    padding.PSS(
        mgf=padding.MGF1(hashes.SHA256()),
        salt_length=padding.PSS.MAX_LENGTH
    ),
    hashes.SHA256()
)

signer.update(json.dumps(actual).encode())
signature = signer.finalize()