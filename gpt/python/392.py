
from Crypto.Cipher import AES
from Crypto.Protocol.KDF import scrypt
from Crypto.Util.number import long_to_bytes

# Assuming HexMyKey and HexEncryptedOriginalMessage are defined
# and contain the hex strings you mentioned

# Convert hex key and encrypted message back to bytes
key = bytes.fromhex(HexMyKey)
data = bytes.fromhex(HexEncryptedOriginalMessage)

# The nonce, ciphertext, and tag need to be separated for decryption
# The nonce size for AES GCM is usually 12 bytes and the tag is typically 16 bytes
nonce_size = 12
tag_size = 16

# Extract nonce, ciphertext, and tag from the encrypted data
nonce = data[:nonce_size]
ciphertext = data[nonce_size:-tag_size]
tag = data[-tag_size:]

# Create a new cipher object with the same key and nonce
cipher = AES.new(key, AES.MODE_G
