import keyring
import requests
from requests_ntlm import HttpNtlmAuth

# Initialize the keyring
keyring.set_password("service_account", "username", "my_secret_password")

# Retrieve the encrypted password from the keyring
encrypted_password = keyring.get_password("service_account", "username")

# Decrypt the password using a secret key
# Note: keyring does not support encryption/decryption, use a library like cryptography instead
from cryptography.fernet import Fernet

decryption_key = Fernet.generate_key()
cipher_suite = Fernet(decryption_key)

# Assuming encrypted_password is a bytes object
decrypted_password = cipher_suite.decrypt(encrypted_password.encode())

# Use the decrypted password to authenticate
auth = HttpNtlmAuth(
    "username",
    decrypted_password.decode()
)

call_string = "https://example.com/api/endpoint"
parameters = {"key": "value"}

content = requests.post(call_string, json=parameters, auth=auth)