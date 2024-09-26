
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend

# Your padded data after decryption (as bytes)
padded_data = b"453947000000197708080808"

# Initialize the unpadder with the block size. PKCS#5 padding is for 8-byte block sizes.
# The block size should be specified in bits, so for PKCS#5, it will be 8 * 8 = 64.
unpadder = padding.PKCS7(64).unpadder()

# Unpad the padded data
unpadded_data = unpadder.update(padded_data) + unpadder.finalize()

# Now `unpadded_data` is the original plaintext without padding (as bytes
