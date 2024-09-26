from cryptography.fernet import Fernet, InvalidToken
import base64

key = Fernet.generate_key()
cipher_suite = Fernet(key)

def is_encrypted(value):
    try:
        cipher_suite.decrypt(base64.urlsafe_b64decode(value))
        return True
    except InvalidToken:
        print("Value was not encrypted with this key.")
        return False

# Example usage
data = "encrypted-or-not"
if is_encrypted(data):
  # Value has been previously encrypted
  print("Value is encrypted")
else:
  # Encrypt the value
  encrypted_data = cipher_suite.encrypt(data.encode())
  print("Encrypted value:", encrypted_data)