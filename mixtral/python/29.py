from Crypto.Cipher import PKCS1_OAEP
from Crypto.PublicKey import RSA

# Generate a new RSA key pair
rsakey = RSA.generate(2048)

# Create a cipher object using the RSA key
cipher = PKCS1_OAEP.new(rsakey)

# Encrypt a message
message = b"Hello, World!"
encrypted_hex_msg = cipher.encrypt(message)

# Decrypt your message
decrypted_message = cipher.decrypt(encrypted_hex_msg)

print(decrypted_message.decode())