from Cryptodome.PublicKey import RSA
from Cryptodome.Signature import PKCS1_v1_5
from Cryptodome.Hash import SHA256
import hashlib

# Load public key
with open('device.pem', 'rb') as fc:
    pub_key = RSA.import_key(fc.read())

# Verify
verifier = PKCS1_v1_5.new(pub_key)
data_sha256 = hashlib.sha256(data).digest()
if verifier.verify(data_sha256, data_sig):
    print("Signature is valid")
else:
    print("Signature is invalid")