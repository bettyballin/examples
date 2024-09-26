from Crypto.Cipher import AES

password = "mysecretpassword".encode()
mode = AES.MODE_ECB
text = "Hello, World!".encode()

enc = AES.new(password, mode)
encrypted = enc.encrypt(text)
print("ORIGINAL: " + text.decode())
print("ENCRYPTED: " + str(encrypted))

dec = AES.new(password, mode)
print("DECRYPTED: " + str(dec.decrypt(encrypted).decode()))