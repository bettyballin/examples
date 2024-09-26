from cryptography.fernet import Fernet
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
import os

# Generate a secure 128-bit key
key_128 = Fernet.generate_key()

# Generate a secure 256-bit key
key_256 = Fernet.generate_key()

# Initialize the counter
ctr = os.urandom(16)

# Initialize the AES contexts
aes_128 = Cipher(algorithms.AES(key_128[:16]), modes.CTR(ctr), backend=default_backend())
aes_256 = Cipher(algorithms.AES(key_256[:32]), modes.CTR(ctr), backend=default_backend())

# Create encryptor objects
aes_128_encryptor = aes_128.encryptor()
aes_256_encryptor = aes_256.encryptor()

# Create decryptor objects
aes_128_decryptor = aes_128.decryptor()
aes_256_decryptor = aes_256.decryptor()