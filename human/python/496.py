import hashlib
import hmac

def hkdf_extract(salt, ikm):
    return hmac.new(salt, ikm, hashlib.sha256).digest()

def hkdf_expand(prk, info, length, salt):
    t = b""
    okm = b""
    i = 1
    while len(okm) < length:
        t = hmac.new(prk, t + info + bytes([i]), hashlib.sha256).digest()
        okm += t
        i += 1
    return okm[:length]

media_key = b"your_media_key"
salt = b"your_salt"

media_key_extracted = hkdf_extract(None, media_key)
media_key_expanded = hkdf_expand(media_key_extracted, b"", 112, salt)