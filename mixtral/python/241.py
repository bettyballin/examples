import os
from cryptography.fernet import Fernet

# Generate a Fernet Key
Key = Fernet.generate_key()

# Set an env variable with the generated/loaded Fernet Key
os.environ['FERNET_KEY'] = Key.decode('utf-8')

def encrypt():
    # Get the environment variable
    fernet_key = os.getenv('FERNET_KEY').encode('utf-8')

    cipher_suite = Fernet(fernet_key)

    # Rest of your code...