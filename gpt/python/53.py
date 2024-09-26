
import hashlib
import hmac
import os

# Generate a strong random salt
salt = os.urandom(16)

# Your secret key - keep it safe!
secret = b'XYZ'

# The user's password
password = b'password'

# Create an HMAC object using a hash function, such as SHA-256
h = hmac.new(secret, salt + password, hashlib.sha256)

# Get the hexadecimal digest of the password hash
password_hash = h.hexdigest()

