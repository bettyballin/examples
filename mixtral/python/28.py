from Crypto.PublicKey import RSA
import base64

# Read and decode the hexadecimal encoded private key
with open("/path/to/key", "r") as f:
    hex_key = f.read().replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "")

der_key = base64.b64decode(bytes.fromhex(hex_key))

# Import the DER-encoded private key
rsakey = RSA.importKey(der_key)