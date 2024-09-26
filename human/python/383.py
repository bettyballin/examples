import base64
import hmac
import hashlib

secretAccessKeyBase64 = "secret"
message = "Message"

secretAccessKey = base64.b64decode(secretAccessKeyBase64)
hash = hmac.new(secretAccessKey, message.encode(), hashlib.sha256)
hashInBase64 = base64.b64encode(hash.digest())

print(hashInBase64.decode())