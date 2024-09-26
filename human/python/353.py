import base64
import hmac
import hashlib

secret = "Ui9+az/p3GdAb1BZ3SJwPkauw2nyT9vm5EE2rzG1OMc="
data = "hello-world"

secret_bytes = base64.b64decode(secret)
data_bytes = data.encode() + b"\n"

hmac_value = hmac.new(secret_bytes, data_bytes, hashlib.sha256).digest()
encoded_hmac = base64.b64encode(hmac_value)

print(encoded_hmac.decode())