from hashlib import sha256
import hmac

def myHash(seed):
    return hmac.new(str(seed).encode('utf-8'), digestmod=sha256).hexdigest()

# Usage
print(myHash('secret'))