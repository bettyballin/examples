#!/usr/bin/env python

from Crypto.PublicKey import RSA
from Crypto import Random

src_data = 'To be, or not to be - that is the question.'
print(src_data)

random_generator = Random.new().read
key = RSA.generate(1024, random_generator)
print('Key generated')

pub_key = key.publickey()
print('Public key', pub_key)

enc_data = pub_key.encrypt(src_data.encode(), 32)[0]
print(enc_data)

dec_data = key.decrypt(enc_data).decode()
print(dec_data)