from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import serialization
import base64

def test_new_crypto():
    privkey = '/path/to/privkey'

    with open(privkey, "rb") as kf:
        private_key = serialization.load_pem_private_key(
            kf.read(),
            password=None,
            backend=default_backend()
        )

    message = b"A message I want to sign"

    # Create a new Signer object
    signer = private_key.signer(
        padding.PSS(
            mgf=padding.MGF1(hashes.SHA256()),
            salt_length=padding.PSS.MAX_LENGTH
        ),
        hashes.SHA256()
    )

    # Update the signer with your message
    signer.update(message)

    # Finalize and get signature
    signature = signer.finalize()

    return base64.b64encode(signature).decode('utf-8')

if __name__ == "__main__":
    print(test_new_crypto())