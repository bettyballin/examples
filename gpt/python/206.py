
import base64
import os

SECRET_KEY = base64.b64encode(os.urandom(32)).decode('utf-8').rstrip('=')

