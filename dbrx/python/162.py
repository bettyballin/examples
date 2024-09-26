import hmac
import hashlib
import base64

secret = b"Ui9+az/p3GdAb1BZ3SJwPkauw2nyT9vm5EE2rzG1OMc="
data   = "hello-world".encode()
key    = secret.strip()  # Remove any trailing whitespace from the key
hmac   = hmac.new(key, data, hashlib.sha256)
result = base64.b64encode(hmac.digest()).decode()

print(result)  # sEDTm/luPTmJ3AveP+wu8B+iXzJ89Rx43QxiWfT9ysM=