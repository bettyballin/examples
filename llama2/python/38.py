import cryptography
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes

# Define the password and salt
password = b'my_secret_password'
salt = b'my_salt'

# Create a PBKDF2 instance with HMAC-SHA1
kdf = PBKDF2HMAC(
    algorithm=hashes.SHA1(),
    length=32,
    salt=salt,
    iterations=1000,
)

# Derive the key
key = kdf.derive(password)

# Use the derived key for encryption
cipher = Cipher(algorithms.AES(key), modes.GCM(b'my_iv'))
encryptor = cipher.encryptor()
decryptor = cipher.decryptor()

# Encrypt some data
data = b'Hello World!'
encrypted_data = encryptor.update(data) + encryptor.finalize()

# Decrypt the data
decrypted_data = decryptor.update(encrypted_data) + decryptor.finalize()

print(decrypted_data.decode())  # Output: Hello World!