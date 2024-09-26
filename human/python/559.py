import hmac
import base64
import hashlib

key = b'your_key_here'
hmac = hmac.new(base64.b64decode(key), digestmod=hashlib.sha512)