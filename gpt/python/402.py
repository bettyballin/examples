
import numpy as np

# Example key, must be carefully chosen to avoid overflow
# The key should contain only factors of 256 (1, 2, 4, 8, 16, 32, 64, 128, 256)
# to ensure that the division will result in an integer value
key = np.ones_like(image, dtype=np.uint8) * 2

# Encryption
encrypted_image =
