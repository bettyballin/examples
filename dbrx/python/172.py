import hmac
import hashlib
import base64

stringToSign = "Test"
secretAccessKey = "bAvW5O18eSrxke4I7eFcrnrDJkN+wKQmx9aSHuMZQ0w="

key_bytes = base64.b64decode(secretAccessKey)
string_to_sign_bytes = bytes(stringToSign, 'utf-8')

signature_hash = hmac.new(key_bytes, string_to_sign_bytes, digestmod=hashlib.sha256).digest()
signature_base64 = base64.b64encode(signature_hash)

print(signature_base64.decode())