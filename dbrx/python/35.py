from Crypto.PublicKey import RSA

with open("/path/to/your/key.pem", "r") as key_file:
    rsakey = RSA.import_key(key_file.read())

# Now you can use `rsakey` for decryption.