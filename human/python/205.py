import hashlib

def bytes_to_key(data, salt="12345678"):
    # Simplified version of M2Crypto.m2.bytes_to_key(). Based on:
    # https://github.com/ajmirsky/M2Crypto/blob/master/M2Crypto/EVP.py#L105
    # http://stackoverflow.com/questions/8008253/c-sharp-version-of-openssl-evp-bytestokey-method
    assert len(salt) == 8, len(salt)
    data += salt.encode()
    key = hashlib.md5(data).digest()
    key += hashlib.md5(key + data).digest()
    return key