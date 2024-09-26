import os
import base64

key = (os.urandom(32)[0:15] + b'\x00\x00')

encoded_key = base64.b64encode(key).decode('utf-8').rstrip("=")