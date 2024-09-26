from nacl.signing import SigningKey
from nacl.encoding import Base64Encoder

signing_key = SigningKey.generate()

priv_key_b64 = signing_key.encode(encoder=Base64Encoder)
pub_key_b64  = signing_key.verify_key.encode(encoder=Base64Encoder)

data = b'testtest'

signed_b64 = signing_key.sign(data, encoder=Base64Encoder)

print(priv_key_b64)         # private key in alpha-numeric encoding
print(pub_key_b64)          # public key in alpha-numeric encoding
print(signed_b64)           # data & signature over data in single chunk

verified = signing_key.verify_key.verify(signed_b64, encoder=Base64Encoder)

print(verified)             # origin 'data' (testtest)