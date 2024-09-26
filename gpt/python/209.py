
privkey = keys  # Keep the actual RSA key object
...
privcipher = PKCS1_OAEP.new(privkey)  # Use the RSA key object for the cipher

