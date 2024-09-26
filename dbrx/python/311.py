import base64
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.hazmat.backends import default_backend

def verify_signature(public_key_base64, data_to_verify, signature):
    """Verify a signature based on the original public key and data."""
    # Decode and import the public key into Python.
    public_key_pem = base64.b64decode(public_key_base64).decode('utf-8')
    deserialized_public_key = serialization.load_pem_public_key(
        public_key_pem.encode('utf-8'),
        default_backend()
    )

    r, s = int(signature['r'], 16), int(signature['s'], 16)

    try:
        # Verify the signature using ECDSA
        deserialized_public_key.verify(
            ec.EllipticCurveDSA(signature=ec.Signature(r, s)),
            data_to_verify,
            ec.ECDSA(ec.SECP256R1())
        )
        return True
    except:
        return False