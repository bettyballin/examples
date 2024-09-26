from cryptography.hazmat.primitives.asymmetric import x25519
import base64

# Assuming you have the Kotlin-generated public key in PEM format (base64-encoded)
kotlin_public_key_pem = """-----BEGIN PUBLIC KEY-----
...
-----END PUBLIC KEY-----"""

# Decode from Base64 and remove header/footer lines
decoded_kotlin_pubkey_bytes = base64.b64decode(kotlin_public_key_pem.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""))

# Load the decoded public key using cryptography library's load_der_public_key function
loaded_public_key = x25519.X25519PublicKey.from_public_bytes(decoded_kotlin_pubkey_bytes)

# Example usage:
private_key = x25519.X25519PrivateKey.generate()
shared_key = private_key.exchange(loaded_public_key)

print(shared_key.hex())