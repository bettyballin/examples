from cryptography.fernet import Fernet
from datetime import timedelta
import base64
import os

key = Fernet.generate_key()
f = Fernet(key)

# Now your token is valid for 1 year from the time of encryption