
import base64
import os

def obs_filename(filename):
    # Convert the filename to bytes, then encode it using URL-safe Base64
    filename_bytes = filename.encode('utf-8')
    encoded_bytes = base64.urlsafe_b64encode(filename_bytes)
    # Decode the bytes back into a str
    encoded_str = encoded_bytes.decode('utf-8')
    # Replace any '=' padding with a URL-safe character, such as '_'
    safe_encoded_str = encoded_str
