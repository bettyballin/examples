import base64
from cryptography.fernet import Fernet

# assuming row is a list or tuple and has at least one element
Key = row[0]
key_decoded = Key.decode('utf8')
key_encoded = base64.urlsafe_b64encode(bytes(key_decoded, 'utf-8'))
Ecy = Fernet(key_encoded)