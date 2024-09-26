
import hmac
import hashlib

# The key and message should be bytes, not str.
# Assuming 'nJ1m4Cc3' is the key, and you're hashing an empty message.
key = b'nJ1m4Cc3'  # The key should be byte type
message = b''  # The message is empty, similar to Go code hasher.Sum(nil)

# Create a new HMAC object using SHA1
hasher = hmac.new(key, message, hashlib.sha1)

# Print the hexadecimal digest
print(hasher.hexdigest())

