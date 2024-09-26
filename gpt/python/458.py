
from cryptography.fernet import Fernet

# Generate a Fernet key
key = Fernet.generate_key()

# The key will be URL-safe base64-encoded 32 bytes
print(key)

# You can then create a Fernet object with this key
f = Fernet(key)

