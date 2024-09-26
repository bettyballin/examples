from cryptography import x509
from cryptography.hazmat.primitives import serialization, hashes
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.exceptions import InvalidSignature
import base64

def validate_token(trusted_cert, payment_data):
    # Extract ephemeralPublicKey from the payload
    ephPub = payment_data['header']['ephemeralPublicKey']

    data = base64.b64decode(ephPub) + base64.b64decode(payment_data['header']['ephemeralPublicKey'])

    trusted_leaf_pub = trusted_cert.public_key()

    try:
        # Verify the signature
        signature = base64.b64decode(payment_data['signature'])
        trusted_leaf_pub.verify(signature, data, ec.ECDSA(hashes.SHA256()))

    except InvalidSignature as err:
         print("Invalid Signature")