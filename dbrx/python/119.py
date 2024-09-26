# This is a simple example of how to use abenc_ks scheme in Charm Crypto library for more complex policies and attributes:

from charm.toolbox.pairinggroup import PairingGroup, GT
from charm.schemes.abenc.abenc_ks import ABEncKS as KS

# Initialize the group
group = PairingGroup('SS512')

# Generate a public key and secret keys
ks = KS(group)
public_key, master_secret_key = ks.setup()

# Define attributes for each user
attributes1 = ['ONE', 'TWO']
secret_key1 = ks.keygen(public_key, master_secret_key, attributes1)

access_policy = '((FOUR or THREE) and (THREE or ONE))'

ciphertext = group.random(GT)
plaintext = group.random(group.G1)

# Encrypt the plaintext with access policy
encrypted_data = ks.encrypt(public_key, ciphertext, access_policy)

# Decrypt using secret key of user 1
decrypted_data = ks.decrypt(secret_key1, encrypted_data)

assert decrypted_data == ciphertext

print("Decryption successful!")