import hashlib
import ecdsa

message = b'Everything should be made as simple as possible, but not simpler.'
private_key_buffer = bytearray.fromhex('0000000000000000000000000000000000000000000000000000000000000001')

digest = hashlib.sha3_256()
digest.update(message)
hash = digest.digest()

sk = ecdsa.SigningKey.from_string(private_key_buffer, curve=ecdsa.SECP256k1)
signature = sk.sign_digest_deterministic(hash, hashfunc=hashlib.sha256)

print(signature.hex())