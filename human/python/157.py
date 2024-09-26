from __future__ import print_function

from Crypto.PublicKey import RSA
from Crypto import Random

def main():
    src_data = 'To be, or not to be - that is the question.'
    print(repr(src_data))

    random_generator = Random.new().read
    key = RSA.generate(1024, random_generator)
    pub_key = key.publickey()
    print('Key generated')

    print(key.exportKey().decode())
    print(pub_key.exportKey().decode())

    enc_data = pub_key.encrypt(src_data.encode(), 32)[0]
    print('Encoded\n', repr(enc_data))

    dec_data = key.decrypt(enc_data).decode()
    print('Decoded\n', repr(dec_data))

if __name__ == "__main__":
    main()