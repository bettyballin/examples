import binascii

from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec


def gen_256_bit_key():
    """
    Generate a new random 32-byte (256-bit) private key for ECDSA secp256k1.
    :return: bytes object containing the raw private key data.
    """
    return ec.generate_private_key(ec.SECP256K1(), default_backend()).private_numbers().private_value.to_bytes(32, 'big')


def save_256_bit_key(key_data):
    """Save a 64-character hexadecimal string representation of your ECDSA secp256k1
       private key to disk.
    :param key_data: bytes object containing the raw private key data.
    """
    with open('privkey.hex', 'w') as f:
        # Serialize the raw private key data into hex format using binascii.hexlify().
        f.write(binascii.hexlify(key_data).decode())


if __name__ == '__main__':
    pk = gen_256_bit_key()
    save_256_bit_key(pk)