import hashlib
import ecdsa

message = 'Everything should be made as simple as possible, but not simpler.'
private_key_buffer = bytes.fromhex('0000000000000000000000000000000000000000000000000000000000000001')

digest = hashlib.sha3_256(message.encode()).digest()

sk = ecdsa.SigningKey.from_string(private_key_buffer, curve=ecdsa.SECP256k1)
signature = sk.sign(digest, sigencode=ecdsa.util.sigencode_der)

print(signature.hex())