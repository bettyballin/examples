
# msg = b'A message for encryption'
with open("plaintext.txt", "rb") as f:
    msg = f.read()  # This ensures 'msg' is in bytes

encryptor = PKCS1_OAEP.new(pubKey)
encrypted = encryptor.encrypt(msg)  # Now 'msg' is a bytes object
print("Encrypted:", binascii.hexlify(encrypted))

