from cryptography.fernet import Fernet
import base64

# Generate a secret key
secret_key = Fernet.generate_key()
fernet = Fernet(secret_key)

# Sample encrypted text
text = "Your_base64_encoded_encrypted_text_here"

decryptedbytes = fernet.decrypt(base64.b64decode(text))