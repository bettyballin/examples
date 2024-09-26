from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_PSS

# Create initial hash object with message data
msg = b'\x15\x0xea'
hash_obj1 = SHA256.new(msg)

# Convert digest to big-endian and create new hash object from it
digest_be = int.from_bytes(hash_obj1.digest(), 'big')
hash_obj2 = SHA256.new(data=digest_be.to_bytes(32, byteorder='big'))

# Load private key (replace with your own private key)
privKey = RSA.generate(2048)

# Pass the second hash object to PKCS1_PSS signer
signer = PKCS1_PSS.new(privKey)
signature = signer.sign(hash_obj2)

print(signature)