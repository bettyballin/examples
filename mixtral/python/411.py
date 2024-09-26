from cryptography import x509
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.exceptions import InvalidSignature
from base64 import b64decode
from cryptography.hazmat.primitives import hashes

def validate_token(trusted_cert, paymentData):
    # Extract ephemeralPublicKey
    ephPub = paymentData['header']['ephemeralPublicKey']

    data = b64decode(ephPub) + b64decode(paymentData['header']['ephemeralPublicKey'])

    trusted_leaf_pub = trusted_cert.public_key()

    try:
        # Verify the signature
        signed_data = x509.SignedData(base64.b64decode(paymentData['signature']))
        trusted_leaf_pub.verify(
            signed_data.signature,
            data,
            padding.PKCS1v15(),
            hashes.SHA256()
        )
    except InvalidSignature:
        print("Invalid Signature")
        return False
    except Exception as e:
        print("Error: ", str(e))
        return False
    return True