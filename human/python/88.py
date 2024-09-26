from pyDes import des, PAD_PKCS5, ECB

data = "Please encrypt my data"
k = des("DESCRYPT", ECB, "\0\0\0\0\0\0\0\0", pad=None, padmode=PAD_PKCS5)
d = k.encrypt(data)
print("Encrypted: %r" % d)
print("Decrypted: %r" % k.decrypt(d))