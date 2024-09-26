
import binascii
salt_bytes = binascii.unhexlify('f7fe4d511bcd33321747a778dd21097f4c0ff98f1e0eba39')
hash = crypto.pbkdf2('test', salt_bytes, 1000, 24, hashlib.sha1)

