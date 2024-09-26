import binascii
from cryptography.fernet import Fernet

encrypted_text = "39085fc25e2..."
cipher = Fernet(key="your_secret_key_here")

binary_data = binascii.unhexlify(encrypted_text)
message = cipher.decrypt(binary_data)

print(message)