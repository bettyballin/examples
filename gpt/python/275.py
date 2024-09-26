
from cryptography.fernet import Fernet, MultiFernet

keystore = []
message = b"foo bar"

# Generate keys and create Fernet instances
for _ in range(4):
    key = Fernet.generate_key()
    fernet_instance = Fernet(key)
    keystore.append(fernet_instance)

# Create a MultiFernet instance using the Fernet instances
f = MultiFernet(keystore)

# Now you can encrypt and decrypt messages
token = f.encrypt(message)
print(token)

# Decrypting the message
decrypted_message = f.decrypt(token)
print(decrypted_message)

