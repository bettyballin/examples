from nacl.signing import SigningKey
from nacl.encoding import Base64Encoder

# Generate the private/public keypair
private_key = SigningKey.generate()

# Encode both keys as base64 strings
encoded_private_key = private_key.encode(encoder=Base64Encoder)
encoded_public_key  = private_key.verify_key.encode(encoder=Base64Encoder)

# Save the encoded keys to text files
with open("private-key.txt", "w") as f:
    f.write(encoded_private_key.decode("utf-8"))

with open("public-key.txt", "w") as g:
    g.write(encoded_public_key.decode("utf-8"))