import hashlib
import struct
from Crypto.PublicKey import RSA
from Crypto.Signature import PKCS1_PSS

# Assuming 'msg' and 'privKey' are defined elsewhere in the code
msg = b"Your message here"
privKey = RSA.generate(2048)

hash = hashlib.sha256(msg)
digest = hash.digest()
big_endian_digest = struct.pack('>32B', *digest)  # Corrected the format string
signer = PKCS1_PSS.new(privKey)
signature = signer.sign(big_endian_digest)