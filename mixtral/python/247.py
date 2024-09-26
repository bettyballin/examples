import hmac
import hashlib
import base64

string_to_sign = "Test"
secret_access_key = "bAvW5O18eSrxke4I7eFcrnrDJkN+wKQmx9aSHuMZQ0w="

# Decode the base64-encoded secret access key to raw bytes
key_bytes = base64.b64decode(secret_access_key)

string_to_sign_bytes = string_to_sign.encode('utf-8')
signature_hash = hmac.new(key_bytes, string_to_sign_bytes, digestmod=hashlib.sha256).digest()

# Encode the resulting HMAC to base64
signature = base64.b64encode(signature_hash)
print(signature)