import hmac
import hashlib

def myHash(seed):
    hash = hmac.new(seed.encode(), 'my message'.encode(), hashlib.sha256).hexdigest()
    return hash

seed = "my_seed"
print(myHash(seed))