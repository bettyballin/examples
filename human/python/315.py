from Crypto.PublicKey import RSA

key = RSA.generate(2048)

# exporting private key
private_key = key.exportKey()
print(private_key)

# exporting public key
public = key.publickey()
public_key = public.exportKey()
print(public_key)