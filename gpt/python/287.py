
import base64
import hmac
import hashlib

stringToSign = "Test"
secretAccessKey = "bAvW5O18eSrxke4I7eFcrnrDJkN+wKQmx9aSHuMZQ0w="

# Decode the base64-encoded secret access key
keyBytes = base64.b64decode(secretAccessKey)

# Convert the string to sign into bytes
stringToSignBytes = bytes(stringToSign, 'utf-8')

# Compute the HMAC
signatureHash = hmac.new(keyBytes, stringToSignBytes, digestmod=hashlib.sha256).digest()

# Encode the HMAC as a base64 string
signature = base64.b64encode(signatureHash).
