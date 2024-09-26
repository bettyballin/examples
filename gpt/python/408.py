
import os
from base64 import b32encode

secret = b32encode(os.urandom(16)).decode().rstrip('=')

