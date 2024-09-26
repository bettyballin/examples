import os
from Crypto.Protocol import KDF
from Crypto.Hash import SHA256
from Crypto.PublicKey import ECC
from Crypto.PublicKey.ECC import EccPoint

# Generate random salt
salt = os.urandom(16)

# Get user input
input_str = input("Enter input: ")
input_bytes = input_str.encode()

# Use the hash of your input as IKM
ikm = SHA256.new(input_bytes).digest()

# Derive a key
key_material = KDF.HKDF(master=ikm, length=32, salt=salt, info=b"ECC Key", context=b'')

# Generate ECC keypair from the derived key
private_key = int.from_bytes(key_material[:16], byteorder='big', signed=False)
G = EccPoint(0x79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798,
             0x483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8)
public_point = private_key * G

# Create an EC public/private key pair
ec_pair = ECC.construct((ECC.curve_256, (public_point[0].to_bytes(32, 'little'),
                                         public_point[1].to_bytes(32, 'little')),
                         private_key))