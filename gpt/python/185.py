
from hashlib import sha256

# Your compressed public key as a string
master_key_hex = "02F840A04114081690223B7069071A70D6DABB891763B638CC20C7EC3BD58E6C86"

# Convert the hexadecimal string to a byte array
master_key_bytes = bytes.fromhex(master_key_hex)

# Compute the SHA-256 hash of the byte array
sha256_result = sha256(master_key_bytes).hexdigest()

print(sha256_result)

