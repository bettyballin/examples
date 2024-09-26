from Crypto.PublicKey import RSA

key = open("/path/to/key", "r").read()
key = key.replace("-----BEGIN RSA PRIVATE KEY-----\n", "")
key = key.replace("-----END RSA PRIVATE KEY-----\n", "")
key = key.strip()
rsakey = RSA.importKey(key)