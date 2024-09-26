import codecs
from Crypto.Cipher import AES
from Crypto.Util import Counter

ct = codecs.decode('5b88aeb265712b6c8bfa8dbd63012d1e52eb42', 'hex')
counter = Counter.new(32, prefix=ct[:12], initial_value=0)
cipher = AES.new(b"1234567890123456", AES.MODE_CTR, counter=counter)
print(cipher.decrypt(ct[12:]))