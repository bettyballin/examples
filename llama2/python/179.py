import nacl.encoding
import nacl.signing

# Base64-encoded private key
private_key = b'e\\xfa ?H\\xd8\\xe7^2\\xfa1\\x18\\xa61\\xca\\x95\\xec~\\x8c\\x011[\\xf8\\x05q!\\xfc\\xe4\\x94\\x13\\xc2\\x89'

# Decode the base64-encoded string
decoded = nacl.encoding.Base64Encoder.decode(private_key)

# Create a signing key from the decoded bytes
signing_key = nacl.signing.SigningKey(decoded)

# Print the plain text private key
print(signing_key.encode(nacl.encoding.Base64Encoder()))