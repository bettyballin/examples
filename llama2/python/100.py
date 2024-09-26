import hmac
import hashlib

def myHash(seed, message):
    hash = hmac.new(seed.encode(), message.encode(), hashlib.sha256).hexdigest()
    return hash

# Test the function
seed = "my_secret_seed"
message = "Hello, World!"
print(myHash(seed, message))