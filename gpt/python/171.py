
from charm.toolbox.pairinggroup import PairingGroup, GT
from charm.toolbox.symcrypto import AuthenticatedCryptoAbstraction
from charm.toolbox.securerandom import OpenSSLRand
from charm.toolbox.ABEnc import ABEnc # import the base class
from charm.schemes.abenc.abenc_bsw07 import CPabe_BSW07

# Your own data
data = "Hello world!"

# Initialize the pairing group
group = PairingGroup('SS512')

# Instantiate the ABE scheme
abe = CPabe_BSW07(group)

# Setup: run by a trusted authority
(public_key,
