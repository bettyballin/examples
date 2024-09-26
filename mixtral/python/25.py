import hashlib
import hmac

h = hmac.new(b"my-key", b"my-data", hashlib.sha1).digest()
print(''.join(["%02x" % x for x in h]))