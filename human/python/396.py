from cryptography.fernet import Fernet

# Im just using a random key for simplicity
key = Fernet.generate_key()
f = Fernet(key)

mystr = 'hi\tthere'

enc = f.encrypt(mystr.encode()) # str.encode() creates a bytes object
dec = f.decrypt(enc)

print(str(dec))
# "b'hi\\tthere'"
# This is NOT the same, use decode

print(mystr==str(dec[2:-1])) # returns False
print(mystr==dec.decode()) # returns True

print(dec.decode())
# 'hi\tthere'