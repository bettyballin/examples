from M2Crypto import RSA

public_key_filename = 'public_key.pem'
with open(public_key_filename, 'r') as f:
    pk = f.read()

rsa = RSA.load_pub_key(pk)