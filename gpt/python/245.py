
from hashlib import sha256
import hmac

def myHash(seed):
    # Assuming that the 'seed' variable is a string, it needs to be encoded to bytes
    seed_bytes = seed.encode('utf-8')
    hash = hmac.new(seed_bytes, b"", sha256).hexdigest()
    return hash

