# Python 2.7 using PyCrypto
from Crypto.Cipher import PKCS1_v1_5
from Crypto.PublicKey import RSA
from Crypto.Hash import SHA1

with open('pub_key.perm', 'r') as key_file:
    public_key = RSA.importKey(key_file.read())

pub_der = public_key.exportKey('DER')  # this assumes PKCS1 by default per the __doc__

print(SHA1.new(pub_der).hexdigest())