import hmac
import hashlib

def verifyHMAC(mac, data, key):
    return hmac.new(key, data, hashlib.sha256).digest() == mac