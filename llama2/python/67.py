from Crypto.PublicKey import RSA

private_key_variable = """-----BEGIN RSA PRIVATE KEY-----
...your private key here...
-----END RSA PRIVATE KEY-----"""

key = RSA.importKey(private_key_variable)