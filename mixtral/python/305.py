from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.backends import default_backend

# Private Key
private_key = 0x63bd3b01c5ce749d87f5f7481232a93540acdb0f7b5c014ecd9cd32b041d6f33
private_key = private_key.to_bytes((private_key.bit_length() + 7) // 8, 'big')

# Public Key
public_key = bytes.fromhex('04'
                           '017655e42a892cc71bccedcb1cd421d03530e1d7edb52cef143c5562c4c6f012'
                           '9fa5a37738013e64a1ff0e6cb7068815a13000eb162cb7a0214dfcf3c8fa101c')

# Load Private Key
private_key = serialization.load_der_private_key(
    b'\x30\x45\x02\x01\x00\x04\x41' + private_key,  # Add DER header
    password=None,
    backend=default_backend()
)

# Load Public Key
public_key = serialization.load_der_public_key(  # Use DER instead of PEM
    b'\x30\x45\x02\x01\x00\x04\x41' + public_key,  # Add DER header
    backend=default_backend()
)