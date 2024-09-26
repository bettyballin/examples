from hashlib import sha256
import hmac

def myHash(seed):
    hash = hmac.new(key=seed.encode(), msg=b'', digestmod=sha256).hexdigest()
    return hash

# Example usage:
seed = "my_secret_seed"
print(myHash(seed))