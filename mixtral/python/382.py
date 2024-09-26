from hashlib import sha256

def hmac_sha256(key, msg):
    blocksize = 64

    if len(key) > blocksize:
        key = sha256(key.encode()).digest()

    while len(key) < blocksize:
        key += b'\x00'

    ipad = b'\x36' * blocksize
    opad = b'\x5c' * blocksize

    inner_pad = bytearray([ip ^ k for (k, ip) in zip(key, ipad)])

    outer_pad = bytearray([op ^ k for (k, op) in zip(key, opad)])

    inner_hash = sha256()

    inner_hash.update(inner_pad + msg.encode())

    return sha256(outer_pad + inner_hash.digest()).hexdigest().upper()

key = 'key'
msg = 'The quick brown fox jumps over the lazy dog'

print(hmac_sha256(key, msg))