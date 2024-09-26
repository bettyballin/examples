import hmac
import hashlib
import struct
import time

def get_hotp_token(secret, intervals_no):
    key = bytearray(secret)
    msg = struct.pack(">Q", intervals_no)
    digest = hmac.new(key, msg, hashlib.sha1).digest()
    offset = digest[-1] & 0x0f
    truncated_digest = digest[offset:offset+4]
    truncated_int = struct.unpack(">I", truncated_digest)[0]
    token = truncated_int & 0x7fffffff
    token = token % 1000000
    return str(token).zfill(6)

secret = 'MZXW633PN5XW6MZX'
for i in range(1, 10):
    print(i, get_hotp_token(secret, intervals_no=i))