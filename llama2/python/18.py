import os
from Crypto.Cipher import AES

# Generate a random secret key
secret = os.urandom(16)

# Initialize the AES cipher in CTR mode
cipher = AES.new(secret, AES.MODE_CTR, counter=AES.Counter.new(128, initial_value=0))

# Encrypt some plaintext
plaintext = b'This is a secret message'
ciphertext = cipher.encrypt(plaintext)

# Decrypt the ciphertext
decrypted = cipher.decrypt(ciphertext)

print("Plaintext:", plaintext)
print("Ciphertext:", ciphertext)
print("Decrypted:", decrypted)