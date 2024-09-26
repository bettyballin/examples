import hmac
import hashlib

data = b'nJ1m4Cc3'
h = hmac.new(key=data, digestmod=hashlib.sha1)
print(h.hexdigest())