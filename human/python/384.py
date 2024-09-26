import base64
import hmac
import hashlib

stringToSign = "Test"
secretAccessKey = "bAvW5O18eSrxke4I7eFcrnrDJkN+wKQmx9aSHuMZQ0w="

secretAccessKeyBase64 = base64.b64decode(secretAccessKey)
keyBytes = secretAccessKeyBase64
stringToSignBytes = bytes(stringToSign, 'utf-8')

signatureHash = hmac.new(keyBytes, stringToSignBytes, digestmod=hashlib.sha256).digest()
signature = base64.b64encode(signatureHash)
print(signature)