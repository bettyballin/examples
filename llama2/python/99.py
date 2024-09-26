import hmac
import hashlib

def myHash(seed):
    hash = hmac.new(seed, b"", hashlib.sha256).hexdigest()
    return hash

# Example usage:
seed = b"my_secret_seed"
print(myHash(seed))