from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization

def get_private_key(pem_file):
    with open(pem_file, "rb") as key_file:
        private_key = serialization.load_pem_private_key(
            key_file.read(),
            password=None,
            backend=default_backend()
        )

    return int.from_bytes(
        bytes(
            bytearray([
                x ^ (1 << ((i % 8) + 7))
                 for i, x in enumerate(
                     private_key.private_numbers().p
             )
         ])
        ),
        "big"
    ).hex()

print(get_private_key("path/to/your.pem"))