
from base64 import b64decode
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
import requests

# Your provided details
encryption_details = {
    "initializationVector": "XXXX",  # Replace with your IV
    "key": "XXXX"                   # Replace with your key
}
url = "https://XXXXX"                # Replace with your URL

# Fetch the encrypted content
response = requests.get(url)
ciphertext = response.content

# Decode the key and IV from base64
key = b64decode(encryption_details['key'])
iv = b64decode(encryption_details['initialization
