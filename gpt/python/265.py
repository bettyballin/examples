
from cryptography.hazmat.primitives import serialization

def gen_key_hex():
    private_key = ec.generate_private_key(ec.SECP256K1(), default_backend())
    # Serialize the private key to bytes and convert to hex
    private_key_bytes = private_key.private_numbers().private_value.to_bytes(32, 'big')
    private_key_hex = private_key_bytes.hex()
    return private_key_hex

if __name__ == '__main__':
    private_key_hex = gen_key_hex()
    print(private_key_hex)  # This will print a 64-character hex
