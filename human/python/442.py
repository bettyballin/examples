from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes, serialization
from cryptography.hazmat.primitives.asymmetric import ec
from cryptography.exceptions import InvalidSignature


def main():
    private_value = 0x63bd3b01c5ce749d87f5f7481232a93540acdb0f7b5c014ecd9cd32b041d6f33
    curve = ec.SECP256R1()
    signature_algorithm = ec.ECDSA(hashes.SHA256())

    # Make private and public keys from the private value + curve
    priv_key = ec.derive_private_key(private_value, curve, default_backend())
    pub_key = priv_key.public_key()
    print('Private key: 0x%x' % priv_key.private_numbers().private_value)
    print('Public point (Uncompressed): 0x%s' % pub_key.public_bytes(serialization.Encoding.X962, serialization.PublicFormat.UncompressedPoint).hex())

    # Sign some data
    data = b"this is some data to sign"
    signature = priv_key.sign(data, signature_algorithm)
    print('Signature: 0x%s' % signature.hex())

    # Verify
    try:
        pub_key.verify(signature, data, signature_algorithm)
        print('Verification OK')
    except InvalidSignature:
        print('Verification failed')


if __name__ == "__main__":
    main()