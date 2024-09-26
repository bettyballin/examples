from Crypto.PublicKey import RSA

priK = """-----BEGIN RSA PRIVATE KEY-----
...your private key here...
-----END RSA PRIVATE KEY-----"""

privateKey = RSA.importKey(priK)
publicKey = privateKey.publickey()