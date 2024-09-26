from Crypto.PublicKey import ECC

with open("private.pem", "rb") as f:
    key = ECC.import_key(f.read())

print(key.public_key().export_key())