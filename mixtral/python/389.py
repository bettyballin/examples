from Crypto.PublicKey import RSA

# Generate a public/ private key pair using 2048 bits key length (192 bytes, 1536 bits)
key = RSA.generate(2048)

# get private and public keys
privkey = key
pubkey = key.publickey()

# save keys to files
with open('private_key.pem', 'wb') as f:
    f.write(privkey.exportKey('PEM'))

with open('public_key.pem', 'wb') as f:
    f.write(pubkey.exportKey('PEM'))